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

package com.nikhilesh.liferay.algorithm.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TreeNodeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TreeNodeLocalService
 * @generated
 */
@ProviderType
public class TreeNodeLocalServiceWrapper implements TreeNodeLocalService,
	ServiceWrapper<TreeNodeLocalService> {
	public TreeNodeLocalServiceWrapper(
		TreeNodeLocalService treeNodeLocalService) {
		_treeNodeLocalService = treeNodeLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _treeNodeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _treeNodeLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _treeNodeLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _treeNodeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _treeNodeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _treeNodeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the tree node to the database. Also notifies the appropriate model listeners.
	*
	* @param treeNode the tree node
	* @return the tree node that was added
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode addTreeNode(
		com.nikhilesh.liferay.algorithm.model.TreeNode treeNode) {
		return _treeNodeLocalService.addTreeNode(treeNode);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode addTreeNode(
		long userId, long treeId, int value, int level, long parentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _treeNodeLocalService.addTreeNode(userId, treeId, value, level,
			parentId, serviceContext);
	}

	/**
	* Creates a new tree node with the primary key. Does not add the tree node to the database.
	*
	* @param treeNodeId the primary key for the new tree node
	* @return the new tree node
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode createTreeNode(
		long treeNodeId) {
		return _treeNodeLocalService.createTreeNode(treeNodeId);
	}

	/**
	* Deletes the tree node from the database. Also notifies the appropriate model listeners.
	*
	* @param treeNode the tree node
	* @return the tree node that was removed
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode deleteTreeNode(
		com.nikhilesh.liferay.algorithm.model.TreeNode treeNode) {
		return _treeNodeLocalService.deleteTreeNode(treeNode);
	}

	/**
	* Deletes the tree node with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node that was removed
	* @throws PortalException if a tree node with the primary key could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode deleteTreeNode(
		long treeNodeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _treeNodeLocalService.deleteTreeNode(treeNodeId);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode deleteTreeNode(
		long treeNodeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _treeNodeLocalService.deleteTreeNode(treeNodeId, serviceContext);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode fetchTreeNode(
		long treeNodeId) {
		return _treeNodeLocalService.fetchTreeNode(treeNodeId);
	}

	/**
	* Returns the tree node matching the UUID and group.
	*
	* @param uuid the tree node's UUID
	* @param groupId the primary key of the group
	* @return the matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode fetchTreeNodeByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _treeNodeLocalService.fetchTreeNodeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the tree node with the primary key.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node
	* @throws PortalException if a tree node with the primary key could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode getTreeNode(
		long treeNodeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _treeNodeLocalService.getTreeNode(treeNodeId);
	}

	/**
	* Returns the tree node matching the UUID and group.
	*
	* @param uuid the tree node's UUID
	* @param groupId the primary key of the group
	* @return the matching tree node
	* @throws PortalException if a matching tree node could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode getTreeNodeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _treeNodeLocalService.getTreeNodeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the tree node in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param treeNode the tree node
	* @return the tree node that was updated
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode updateTreeNode(
		com.nikhilesh.liferay.algorithm.model.TreeNode treeNode) {
		return _treeNodeLocalService.updateTreeNode(treeNode);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.TreeNode updateTreeNode(
		long userId, long treeId, long treeNodeId, int value, int level,
		long parentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _treeNodeLocalService.updateTreeNode(userId, treeId, treeNodeId,
			value, level, parentId, serviceContext);
	}

	/**
	* Returns the number of tree nodes.
	*
	* @return the number of tree nodes
	*/
	@Override
	public int getTreeNodesCount() {
		return _treeNodeLocalService.getTreeNodesCount();
	}

	@Override
	public int getTreeNodesCount(long groupId, long treeId) {
		return _treeNodeLocalService.getTreeNodesCount(groupId, treeId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _treeNodeLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _treeNodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nikhilesh.liferay.algorithm.model.impl.TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _treeNodeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nikhilesh.liferay.algorithm.model.impl.TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _treeNodeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the tree nodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nikhilesh.liferay.algorithm.model.impl.TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @return the range of tree nodes
	*/
	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.TreeNode> getTreeNodes(
		int start, int end) {
		return _treeNodeLocalService.getTreeNodes(start, end);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.TreeNode> getTreeNodes(
		long groupId, long treeId) {
		return _treeNodeLocalService.getTreeNodes(groupId, treeId);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.TreeNode> getTreeNodes(
		long groupId, long treeId, int start, int end) {
		return _treeNodeLocalService.getTreeNodes(groupId, treeId, start, end);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.TreeNode> getTreeNodes(
		long groupId, long treeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.TreeNode> obc) {
		return _treeNodeLocalService.getTreeNodes(groupId, treeId, start, end,
			obc);
	}

	/**
	* Returns all the tree nodes matching the UUID and company.
	*
	* @param uuid the UUID of the tree nodes
	* @param companyId the primary key of the company
	* @return the matching tree nodes, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.TreeNode> getTreeNodesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _treeNodeLocalService.getTreeNodesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of tree nodes matching the UUID and company.
	*
	* @param uuid the UUID of the tree nodes
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching tree nodes, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.TreeNode> getTreeNodesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.TreeNode> orderByComparator) {
		return _treeNodeLocalService.getTreeNodesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _treeNodeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _treeNodeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public TreeNodeLocalService getWrappedService() {
		return _treeNodeLocalService;
	}

	@Override
	public void setWrappedService(TreeNodeLocalService treeNodeLocalService) {
		_treeNodeLocalService = treeNodeLocalService;
	}

	private TreeNodeLocalService _treeNodeLocalService;
}