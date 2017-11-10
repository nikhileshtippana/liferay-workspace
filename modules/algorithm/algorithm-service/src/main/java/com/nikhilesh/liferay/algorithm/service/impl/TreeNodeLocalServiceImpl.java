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

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.nikhilesh.liferay.algorithm.exception.TreeNodeLevelException;
import com.nikhilesh.liferay.algorithm.model.ALGTree;
import com.nikhilesh.liferay.algorithm.model.TreeNode;
import com.nikhilesh.liferay.algorithm.service.base.TreeNodeLocalServiceBaseImpl;

/**
 * The implementation of the tree node local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nikhilesh.liferay.algorithm.service.TreeNodeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreeNodeLocalServiceBaseImpl
 * @see com.nikhilesh.liferay.algorithm.service.TreeNodeLocalServiceUtil
 */
public class TreeNodeLocalServiceImpl extends TreeNodeLocalServiceBaseImpl {
	
	public List<TreeNode> getTreeNodes(long groupId, long treeId) {

		return treeNodePersistence.findByG_T(groupId, treeId);
	}

	public List<TreeNode> getTreeNodes(long groupId, long treeId, int start, int end, 
			OrderByComparator<TreeNode> obc) {

		return treeNodePersistence.findByG_T(groupId, treeId, start, end, obc);
	}

	public List<TreeNode> getTreeNodes(long groupId, long treeId, int start, int end) {

		return treeNodePersistence.findByG_T(groupId, treeId, start, end);
	}

	public int getTreeNodesCount(long groupId, long treeId) {

		return treeNodePersistence.countByG_T(groupId, treeId);
	}
	
	protected void validate(int value, int level, long parentId) throws PortalException {
		if (level == 0) {
			throw new TreeNodeLevelException();
		}
	}
	
	public TreeNode addTreeNode (
			long userId, long treeId, int value, int level, long parentId, ServiceContext serviceContext)
					throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUser(userId);
		Date now = new Date();

		validate(value, level, parentId);
		
		long treeNodeId = counterLocalService.increment();
		
		TreeNode treeNode = treeNodePersistence.create(treeNodeId);
		
		treeNode.setUuid(serviceContext.getUuid());
		treeNode.setUserId(userId);
		treeNode.setGroupId(groupId);
		treeNode.setCompanyId(user.getCompanyId());
		treeNode.setUserName(user.getFullName());
		treeNode.setCreateDate(serviceContext.getCreateDate(now));
		treeNode.setModifiedDate(serviceContext.getModifiedDate(now));
		treeNode.setValue(value);
		treeNode.setLevel(level);
		treeNode.setParentId(parentId);
		treeNode.setTreeId(treeId);
		treeNode.setExpandoBridgeAttributes(serviceContext);
		
		treeNodePersistence.update(treeNode);
		
		return treeNode;
	}
	
	public TreeNode updateTreeNode (
			long userId, long treeId, long treeNodeId, int value, int level, long parentId, ServiceContext serviceContext)
					throws PortalException {
		Date now = new Date();
		TreeNode treeNode = getTreeNode(treeNodeId);
		
		validate(value, level, parentId);

		User user = userLocalService.getUser(userId);

		treeNode.setUserId(userId);
		treeNode.setUserName(user.getFullName());
		treeNode.setModifiedDate(serviceContext.getModifiedDate(now));
		treeNode.setValue(value);
		treeNode.setLevel(level);
		treeNode.setParentId(parentId);
		treeNode.setExpandoBridgeAttributes(serviceContext);
		
		treeNodePersistence.update(treeNode);
		
		return treeNode;
	}
	
	public TreeNode deleteTreeNode(long treeNodeId, ServiceContext serviceContext) throws PortalException, SystemException {

		TreeNode treeNode = getTreeNode(treeNodeId);

		treeNode = deleteTreeNode(treeNode);
		
		return treeNode;
	}
	
}