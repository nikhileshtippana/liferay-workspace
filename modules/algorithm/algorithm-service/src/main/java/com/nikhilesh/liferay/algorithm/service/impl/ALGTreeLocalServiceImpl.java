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

package com.nikhilesh.liferay.algorithm.service.impl;

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
import com.nikhilesh.liferay.algorithm.exception.ALGTreeNameException;
import com.nikhilesh.liferay.algorithm.model.ALGTree;
import com.nikhilesh.liferay.algorithm.model.TreeNode;
import com.nikhilesh.liferay.algorithm.service.base.ALGTreeLocalServiceBaseImpl;

/**
 * The implementation of the alg tree local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nikhilesh.liferay.algorithm.service.ALGTreeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ALGTreeLocalServiceBaseImpl
 * @see com.nikhilesh.liferay.algorithm.service.ALGTreeLocalServiceUtil
 */
public class ALGTreeLocalServiceImpl extends ALGTreeLocalServiceBaseImpl {
	
	public List<ALGTree> getALGTrees(long groupId) {

		return algTreePersistence.findByGroup(groupId);
	}

	public List<ALGTree> getALGTrees(long groupId, int start, int end, 
			OrderByComparator<ALGTree> obc) {

		return algTreePersistence.findByGroup(groupId, start, end, obc);
	}

	public List<ALGTree> getALGTrees(long groupId, int start, int end) {

		return algTreePersistence.findByGroup(groupId, start, end);
	}

	public int getALGTreesCount(long groupId) {

		return algTreePersistence.countByGroup(groupId);
	}
	
	public List<ALGTree> getALGTrees(long groupId, int status) {

		return algTreePersistence.findByG_S(groupId, status);
	}

	public List<ALGTree> getALGTrees(long groupId, int status, int start, int end, 
			OrderByComparator<ALGTree> obc) {

		return algTreePersistence.findByG_S(groupId, status, start, end, obc);
	}

	public List<ALGTree> getALGTrees(long groupId, int status, int start, int end) {

		return algTreePersistence.findByG_S(groupId, status, start, end);
	}

	public int getALGTreesCount(long groupId, int status) {

		return algTreePersistence.countByG_S(groupId, status);
	}

	protected void validate(String name, String description, int status) throws PortalException {
		if (status == WorkflowConstants.STATUS_APPROVED && Validator.isNull(name)) {
			throw new ALGTreeNameException();
		}
	}

	@Indexable(type = IndexableType.REINDEX)
	public ALGTree addTree(
			long userId, String name, String description, ServiceContext serviceContext, boolean disableWorkflow)
					throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		int status = disableWorkflow ? WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_DRAFT;

		validate(name, description, status);
		
		long treeId = counterLocalService.increment();
		
		ALGTree tree = algTreePersistence.create(treeId);

		tree.setUuid(serviceContext.getUuid());
		tree.setUserId(userId);
		tree.setGroupId(groupId);
		tree.setCompanyId(user.getCompanyId());
		tree.setUserName(user.getFullName());
		tree.setCreateDate(serviceContext.getCreateDate(now));
		tree.setModifiedDate(serviceContext.getModifiedDate(now));
		tree.setName(name);
		tree.setDescription(description);
		if (!disableWorkflow) {
			tree.setStatus(status);
			tree.setStatusByUserId(userId);
			tree.setStatusByUserName(user.getFullName());
			tree.setStatusDate(serviceContext.getModifiedDate(null));
		}
		tree.setExpandoBridgeAttributes(serviceContext);
		
		algTreePersistence.update(tree);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, ALGTree.class.getName(), treeId, false, true, true);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, tree.getCreateDate(),
				tree.getModifiedDate(), ALGTree.class.getName(),
				treeId, tree.getUuid(), 0L,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, null, null, null,
				ContentTypes.TEXT_HTML, tree.getName(), tree.getDescription(), null, null,
				null, 0, 0, null);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		
		return disableWorkflow ? tree : startWorkflowInstance(userId, tree, serviceContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	public ALGTree addTree(
			long userId, String name, String description, ServiceContext serviceContext)
					throws PortalException {

		return addTree(userId, name, description, serviceContext, false);
	}

	@Indexable(type = IndexableType.REINDEX)
	public ALGTree updateTree(
			long userId, long treeId, String name, String description, ServiceContext serviceContext)
					throws PortalException {
		Date now = new Date();
		ALGTree tree = getALGTree(treeId);
		int status = tree.getStatus();
		
		if (!tree.isPending() && !tree.isDraft()) {
			status = WorkflowConstants.STATUS_DRAFT;
		}
		
		validate(name, description, status);

		User user = userLocalService.getUser(userId);

		tree.setUserId(userId);
		tree.setUserName(user.getFullName());
		tree.setModifiedDate(serviceContext.getModifiedDate(now));
		tree.setName(name);
		tree.setDescription(description);
		tree.setExpandoBridgeAttributes(serviceContext);
		
		algTreePersistence.update(tree);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(), 
                ALGTree.class.getName(), treeId,
                serviceContext.getGroupPermissions(),
                serviceContext.getGuestPermissions());
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(tree.getUserId(),
				tree.getGroupId(), tree.getCreateDate(),
				tree.getModifiedDate(), ALGTree.class.getName(),
				treeId, tree.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, tree.getCreateDate(), 
				null, null, ContentTypes.TEXT_HTML, tree.getName(), tree.getDescription(), null, 
				null, null, 0, 0, serviceContext.getAssetPriority());

		assetLinkLocalService.updateLinks(serviceContext.getUserId(),
				assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		return startWorkflowInstance(userId, tree, serviceContext);
	}

	@Indexable(type = IndexableType.DELETE)
	public ALGTree deleteTree(long treeId,
			ServiceContext serviceContext) throws PortalException, SystemException {

		ALGTree tree = getALGTree(treeId);
		
		try {
			WorkflowInstanceLink workflowInstanceLink = workflowInstanceLinkLocalService.getWorkflowInstanceLink(tree.getCompanyId(), tree.getGroupId(), ALGTree.class.getName(), treeId);
			workflowInstanceManager.deleteWorkflowInstance(tree.getCompanyId(), workflowInstanceLink.getWorkflowInstanceId());
		} catch (Exception e) {
			Logger.getLogger(ALGTree.class.getName()).log(Level.WARNING, null, e);
		}
		
		List<TreeNode> treeNodes = treeNodeLocalService.getTreeNodes(tree.getGroupId(), tree.getTreeId());
		
		for (TreeNode treeNode : treeNodes) {
			treeNodeLocalService.deleteTreeNode(treeNode.getTreeNodeId(), serviceContext);
		}

		tree = deleteALGTree(tree);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
                ALGTree.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
                treeId);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(ALGTree.class.getName(), treeId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		return tree;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public ALGTree updateStatus(long userId, long treeId, int status, ServiceContext serviceContext) throws PortalException, SystemException {
		ALGTree tree = getALGTree(treeId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		validate(tree.getName(), tree.getDescription(), status);
		
		tree.setStatus(status);
		tree.setStatusByUserId(user.getUserId());
		tree.setStatusByUserName(user.getFullName());
		tree.setStatusDate(serviceContext.getModifiedDate(now));
		
		algTreePersistence.update(tree);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateEntry(ALGTree.class.getName(), treeId, now, null, true, true);
		}
		else {
			assetEntryLocalService.updateVisible(ALGTree.class.getName(), treeId, false);
		}
		
		return tree;
	}
	
	protected ALGTree startWorkflowInstance(long userId, ALGTree tree, ServiceContext serviceContext) throws PortalException {
		Map<String, Serializable> workflowContext = new HashMap<>();
		
		workflowContext.put(WorkflowConstants.CONTEXT_URL, getTreeURL(tree, serviceContext));
		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);
		
		return WorkflowHandlerRegistryUtil.startWorkflowInstance(tree.getCompanyId(), tree.getGroupId(), userId, ALGTree.class.getName(), tree.getTreeId(), tree, serviceContext, workflowContext);
	}
	
	protected String getTreeURL(ALGTree tree, ServiceContext serviceContext) throws PortalException {

		String guestbookURL = GetterUtil.getString(serviceContext.getAttribute("treeURL"));

		if (Validator.isNotNull(guestbookURL)) {
			return guestbookURL;
		}

		HttpServletRequest request = serviceContext.getRequest();

		if (request == null) {
			return StringPool.BLANK;
		}

		String portletId = PortletProviderUtil.getPortletId(ALGTree.class.getName(), PortletProvider.Action.VIEW);
		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(request, portletId, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/guestbookadminportlet/edit_guestbook.jsp");
		portletURL.setParameter("treeId", String.valueOf(tree.getTreeId()));

		return portletURL.toString();
	}

	@ServiceReference(type = WorkflowInstanceLinkLocalService.class)
	protected WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	@ServiceReference(type = WorkflowInstanceManager.class)
	protected WorkflowInstanceManager workflowInstanceManager;
	
}