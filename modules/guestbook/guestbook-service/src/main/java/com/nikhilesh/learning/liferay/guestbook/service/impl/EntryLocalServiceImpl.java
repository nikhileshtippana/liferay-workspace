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
import com.nikhilesh.learning.liferay.guestbook.exception.EntryEmailException;
import com.nikhilesh.learning.liferay.guestbook.exception.EntryMessageException;
import com.nikhilesh.learning.liferay.guestbook.exception.EntryNameException;
import com.nikhilesh.learning.liferay.guestbook.model.Entry;
import com.nikhilesh.learning.liferay.guestbook.service.base.EntryLocalServiceBaseImpl;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nikhilesh.learning.liferay.Entry.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nik
 * @see EntryLocalServiceBaseImpl
 * @see com.nikhilesh.learning.liferay.Entry.service.EntryLocalServiceUtil
 */
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {

	public List<Entry> getEntries(long groupId, long EntryId) {
		return entryPersistence.findByG_G(groupId, EntryId);
	}
	
	public List<Entry> getEntries(long groupId, long EntryId, int start, int end)
			throws SystemException {
		
		return entryPersistence.findByG_G(groupId, EntryId, start, end);
	}
	
	public List<Entry> getEntries(
			long groupId, long EntryId, int start, int end, OrderByComparator<Entry> obc) {
		
		return entryPersistence.findByG_G(groupId, EntryId, start, end, obc);
	}
	
	public int getEntriesCount(long groupId, long EntryId) {
		return entryPersistence.countByG_G(groupId, EntryId);
	}

	public List<Entry> getEntries(long groupId, long EntryId, int status) {
		return entryPersistence.findByG_G_S(groupId, EntryId, status);
	}
	
	public List<Entry> getEntries(long groupId, long EntryId, int status, int start, int end)
			throws SystemException {
		
		return entryPersistence.findByG_G_S(groupId, EntryId, status, start, end);
	}
	
	public List<Entry> getEntries(
			long groupId, long EntryId, int status, int start, int end, OrderByComparator<Entry> obc) {
		
		return entryPersistence.findByG_G_S(groupId, EntryId, status, start, end, obc);
	}
	
	public int getEntriesCount(long groupId, long EntryId, int status) {
		return entryPersistence.countByG_G_S(groupId, EntryId, status);
	}
	
	protected void validate(String name, String email, String message, int status)
			throws PortalException {
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (Validator.isNull(name)) {
				throw new EntryNameException();
			}
			
			if (!Validator.isEmailAddress(email)) {
				throw new EntryEmailException();
			}
			
			if (Validator.isNull(message)) {
				throw new EntryMessageException();
			}
		}
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Entry addEntry(
			long userId, long guestbookId, String name, String email,
			String message, ServiceContext serviceContext)
					throws PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		int status = WorkflowConstants.STATUS_DRAFT;
		
		validate(name, email, message, status);
		
		long entryId = counterLocalService.increment();
		
		Entry entry = entryPersistence.create(entryId);
		
		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setExpandoBridgeAttributes(serviceContext);
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		entry.setGuestbookId(guestbookId);
		
		entryPersistence.update(entry);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    Entry.class.getName(), entryId, false, true, true);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, entry.getCreateDate(), entry.getModifiedDate(),
				Entry.class.getName(), entryId, entry.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, null, null, null,
				ContentTypes.TEXT_HTML, entry.getMessage(), null, null, null,
				null, 0, 0, null);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		return startWorkflowInstance(userId, entry, serviceContext);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Entry updateEntry (
			long userId, long guestbookId, long entryId, String name, String email,
			String message, ServiceContext serviceContext)
					throws PortalException, SystemException {
		
		Date now = new Date();
		Entry entry = getEntry(entryId);
		int status = entry.getStatus();
		
		if (!entry.isPending() && !entry.isDraft()) {
			status = WorkflowConstants.STATUS_DRAFT;
		}
		
		validate(name, email, message, status);
		
		User user = userLocalService.getUserById(userId);
		
		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		entry.setExpandoBridgeAttributes(serviceContext);
		
		entryPersistence.update(entry);
		
		resourceLocalService.updateResources(
			      user.getCompanyId(), serviceContext.getScopeGroupId(), 
			      Entry.class.getName(), entryId, serviceContext.getGroupPermissions(),
			      serviceContext.getGuestPermissions());
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				serviceContext.getScopeGroupId(),
				entry.getCreateDate(), entry.getModifiedDate(),
				Entry.class.getName(), entryId, entry.getUuid(),
				0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true,
				entry.getCreateDate(), null, null,
				ContentTypes.TEXT_HTML, entry.getMessage(), null,
				null, null, null, 0, 0,
				serviceContext.getAssetPriority());

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		return startWorkflowInstance(userId, entry, serviceContext);
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Entry deleteEntry (long entryId, ServiceContext serviceContext)
			throws PortalException {
		
		Entry entry = getEntry(entryId);
		
		entry = deleteEntry(entryId);
		
		try {
			WorkflowInstanceLink workflowInstanceLink = workflowInstanceLinkLocalService.getWorkflowInstanceLink(entry.getCompanyId(), entry.getGroupId(), Entry.class.getName(), entryId);
			workflowInstanceManager.deleteWorkflowInstance(entry.getCompanyId(), workflowInstanceLink.getWorkflowInstanceId());
		} catch (Exception e) {
			Logger.getLogger(Entry.class.getName()).log(Level.WARNING, null, e);
		}
		
		resourceLocalService.deleteResource(
	               serviceContext.getCompanyId(), Entry.class.getName(),
	               ResourceConstants.SCOPE_INDIVIDUAL, entryId);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				Entry.class.getName(), entryId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		return entry;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Entry updateStatus(long userId, long entryId, int status, ServiceContext serviceContext) throws PortalException, SystemException {
		Entry entry = getEntry(entryId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		validate(entry.getName(), entry.getEmail(), entry.getMessage(), entry.getStatus());
		
		entry.setStatus(status);
		entry.setStatusByUserId(user.getUserId());
		entry.setStatusByUserName(user.getFullName());
		entry.setStatusDate(serviceContext.getModifiedDate(now));
		
		entryPersistence.update(entry);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateEntry(Entry.class.getName(), entryId, now, null, true, true);
		}
		else {
			assetEntryLocalService.updateVisible(Entry.class.getName(), entryId, false);
		}
		
		return entry;
	}
	
	protected Entry startWorkflowInstance(long userId, Entry entry, ServiceContext serviceContext) throws PortalException {
		Map<String, Serializable> workflowContext = new HashMap<>();
		
		workflowContext.put(WorkflowConstants.CONTEXT_URL, getEntryURL(entry, serviceContext));
		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);
		
		return WorkflowHandlerRegistryUtil.startWorkflowInstance(entry.getCompanyId(), entry.getGroupId(), userId, Entry.class.getName(), entry.getEntryId(), entry, serviceContext, workflowContext);
	}
	
	protected String getEntryURL(Entry entry, ServiceContext serviceContext) throws PortalException {

		String EntryURL = GetterUtil.getString(serviceContext.getAttribute("entryURL"));

		if (Validator.isNotNull(EntryURL)) {
			return EntryURL;
		}

		HttpServletRequest request = serviceContext.getRequest();

		if (request == null) {
			return StringPool.BLANK;
		}

		String portletId = PortletProviderUtil.getPortletId(Entry.class.getName(), PortletProvider.Action.VIEW);
		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(request, portletId, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/Entryadminportlet/edit_Entry.jsp");
		portletURL.setParameter("EntryId", String.valueOf(entry.getEntryId()));

		return portletURL.toString();
	}

	@ServiceReference(type = WorkflowInstanceLinkLocalService.class)
	protected WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	@ServiceReference(type = WorkflowInstanceManager.class)
	protected WorkflowInstanceManager workflowInstanceManager;

}