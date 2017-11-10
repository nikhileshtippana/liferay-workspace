/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.nikhilesh.learning.liferay.guestbook.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManager;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.nikhilesh.learning.liferay.guestbook.exception.GuestbookNameException;
import com.nikhilesh.learning.liferay.guestbook.model.Entry;
import com.nikhilesh.learning.liferay.guestbook.model.Guestbook;
import com.nikhilesh.learning.liferay.guestbook.service.base.GuestbookLocalServiceBaseImpl;

/**
 * The implementation of the guestbook local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nikhilesh.learning.liferay.guestbook.service.GuestbookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nik
 * @see GuestbookLocalServiceBaseImpl
 * @see com.nikhilesh.learning.liferay.guestbook.service.GuestbookLocalServiceUtil
 */
public class GuestbookLocalServiceImpl extends GuestbookLocalServiceBaseImpl {
	
	public List<Guestbook> getGuestbooks(long groupId) {

		return guestbookPersistence.findByGroupId(groupId);
	}

	public List<Guestbook> getGuestbooks(long groupId, int start, int end, 
			OrderByComparator<Guestbook> obc) {

		return guestbookPersistence.findByGroupId(groupId, start, end, obc);
	}

	public List<Guestbook> getGuestbooks(long groupId, int start, int end) {

		return guestbookPersistence.findByGroupId(groupId, start, end);
	}

	public int getGuestbooksCount(long groupId) {

		return guestbookPersistence.countByGroupId(groupId);
	}
	
	public List<Guestbook> getGuestbooks(long groupId, int status) {

		return guestbookPersistence.findByG_S(groupId, status);
	}

	public List<Guestbook> getGuestbooks(long groupId, int status, int start, int end, 
			OrderByComparator<Guestbook> obc) {

		return guestbookPersistence.findByG_S(groupId, status, start, end, obc);
	}

	public List<Guestbook> getGuestbooks(long groupId, int status, int start, int end) {

		return guestbookPersistence.findByG_S(groupId, status, start, end);
	}

	public int getGuestbooksCount(long groupId, int status) {

		return guestbookPersistence.countByG_S(groupId, status);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Guestbook addGuestbook(
			long userId, String name, ServiceContext serviceContext, boolean disableWorkflow)
					throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		int status = disableWorkflow ? WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_DRAFT;

		validate(name, status);

		long guestbookId = counterLocalService.increment();

		Guestbook guestbook = guestbookPersistence.create(guestbookId);

		guestbook.setUuid(serviceContext.getUuid());
		guestbook.setUserId(userId);
		guestbook.setGroupId(groupId);
		guestbook.setCompanyId(user.getCompanyId());
		guestbook.setUserName(user.getFullName());
		guestbook.setCreateDate(serviceContext.getCreateDate(now));
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		if (!disableWorkflow) {
			guestbook.setStatus(status);
			guestbook.setStatusByUserId(userId);
			guestbook.setStatusByUserName(user.getFullName());
			guestbook.setStatusDate(serviceContext.getModifiedDate(null));
		}
		guestbook.setExpandoBridgeAttributes(serviceContext);
		
		guestbookPersistence.update(guestbook);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Guestbook.class.getName(), guestbookId, false, true, true);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, guestbook.getCreateDate(),
				guestbook.getModifiedDate(), Guestbook.class.getName(),
				guestbookId, guestbook.getUuid(), 0L,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, null, null, null,
				ContentTypes.TEXT_HTML, guestbook.getName(), null, null, null,
				null, 0, 0, null);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		
		return disableWorkflow ? guestbook : startWorkflowInstance(userId, guestbook, serviceContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Guestbook addGuestbook(
			long userId, String name, ServiceContext serviceContext)
					throws PortalException {

		return addGuestbook(userId, name, serviceContext, false);
	}

	protected void validate(String name, int status) throws PortalException {
		if (status == WorkflowConstants.STATUS_APPROVED && Validator.isNull(name)) {
			throw new GuestbookNameException();
		}
	}

	@Indexable(type = IndexableType.REINDEX)
	public Guestbook updateGuestbook(long userId, long guestbookId,
			String name, ServiceContext serviceContext) throws PortalException,
	SystemException {

		Date now = new Date();

		Guestbook guestbook = getGuestbook(guestbookId);
		int status = guestbook.getStatus();
		
		if (!guestbook.isPending() && !guestbook.isDraft()) {
			status = WorkflowConstants.STATUS_DRAFT;
		}
		
		validate(name, status);

		User user = userLocalService.getUser(userId);

		guestbook.setUserId(userId);
		guestbook.setUserName(user.getFullName());
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		guestbook.setExpandoBridgeAttributes(serviceContext);

		guestbookPersistence.update(guestbook);

		resourceLocalService.updateResources(serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(), 
                Guestbook.class.getName(), guestbookId,
                serviceContext.getGroupPermissions(),
                serviceContext.getGuestPermissions());
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(guestbook.getUserId(),
				guestbook.getGroupId(), guestbook.getCreateDate(),
				guestbook.getModifiedDate(), Guestbook.class.getName(),
				guestbookId, guestbook.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, guestbook.getCreateDate(), 
				null, null, ContentTypes.TEXT_HTML, guestbook.getName(), null, null, 
				null, null, 0, 0, serviceContext.getAssetPriority());

		assetLinkLocalService.updateLinks(serviceContext.getUserId(),
				assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		return startWorkflowInstance(userId, guestbook, serviceContext);
	}

	@Indexable(type = IndexableType.DELETE)
	public Guestbook deleteGuestbook(long guestbookId,
			ServiceContext serviceContext) throws PortalException, SystemException {

		Guestbook guestbook = getGuestbook(guestbookId);
		
		try {
			WorkflowInstanceLink workflowInstanceLink = workflowInstanceLinkLocalService.getWorkflowInstanceLink(guestbook.getCompanyId(), guestbook.getGroupId(), Guestbook.class.getName(), guestbookId);
			workflowInstanceManager.deleteWorkflowInstance(guestbook.getCompanyId(), workflowInstanceLink.getWorkflowInstanceId());
		} catch (Exception e) {
			Logger.getLogger(Guestbook.class.getName()).log(Level.WARNING, null, e);
		}
		
		List<Entry> entries = entryLocalService.getEntries(serviceContext.getScopeGroupId(), guestbookId);

		for (Entry entry : entries) {
			entryLocalService.deleteEntry(entry.getEntryId());
		}

		guestbook = deleteGuestbook(guestbook);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
                Guestbook.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
                guestbookId);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Guestbook.class.getName(), guestbookId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		return guestbook;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Guestbook updateStatus(long userId, long guestbookId, int status, ServiceContext serviceContext) throws PortalException, SystemException {
		Guestbook guestbook = getGuestbook(guestbookId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		validate(guestbook.getName(), status);
		
		guestbook.setStatus(status);
		guestbook.setStatusByUserId(user.getUserId());
		guestbook.setStatusByUserName(user.getFullName());
		guestbook.setStatusDate(serviceContext.getModifiedDate(now));
		
		guestbookPersistence.update(guestbook);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateEntry(Guestbook.class.getName(), guestbookId, now, null, true, true);
		}
		else {
			assetEntryLocalService.updateVisible(Guestbook.class.getName(), guestbookId, false);
		}
		
		return guestbook;
	}
	
	protected Guestbook startWorkflowInstance(long userId, Guestbook guestbook, ServiceContext serviceContext) throws PortalException {
		Map<String, Serializable> workflowContext = new HashMap<>();
		
		workflowContext.put(WorkflowConstants.CONTEXT_URL, getGuestbookURL(guestbook, serviceContext));
		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);
		
		return WorkflowHandlerRegistryUtil.startWorkflowInstance(guestbook.getCompanyId(), guestbook.getGroupId(), userId, Guestbook.class.getName(), guestbook.getGuestbookId(), guestbook, serviceContext, workflowContext);
	}
	
	protected String getGuestbookURL(Guestbook guestbook, ServiceContext serviceContext) throws PortalException {

		String guestbookURL = GetterUtil.getString(serviceContext.getAttribute("guestbookURL"));

		if (Validator.isNotNull(guestbookURL)) {
			return guestbookURL;
		}

		HttpServletRequest request = serviceContext.getRequest();

		if (request == null) {
			return StringPool.BLANK;
		}

		String portletId = PortletProviderUtil.getPortletId(Guestbook.class.getName(), PortletProvider.Action.VIEW);
		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(request, portletId, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/guestbookadminportlet/edit_guestbook.jsp");
		portletURL.setParameter("guestbookId", String.valueOf(guestbook.getGuestbookId()));

		return portletURL.toString();
	}

	@ServiceReference(type = WorkflowInstanceLinkLocalService.class)
	protected WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	@ServiceReference(type = WorkflowInstanceManager.class)
	protected WorkflowInstanceManager workflowInstanceManager;

}