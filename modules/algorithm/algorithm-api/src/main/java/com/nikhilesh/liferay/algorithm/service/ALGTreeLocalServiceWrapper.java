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
 * Provides a wrapper for {@link ALGTreeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ALGTreeLocalService
 * @generated
 */
@ProviderType
public class ALGTreeLocalServiceWrapper implements ALGTreeLocalService,
	ServiceWrapper<ALGTreeLocalService> {
	public ALGTreeLocalServiceWrapper(ALGTreeLocalService algTreeLocalService) {
		_algTreeLocalService = algTreeLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _algTreeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _algTreeLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _algTreeLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _algTreeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the alg tree to the database. Also notifies the appropriate model listeners.
	*
	* @param algTree the alg tree
	* @return the alg tree that was added
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree addALGTree(
		com.nikhilesh.liferay.algorithm.model.ALGTree algTree) {
		return _algTreeLocalService.addALGTree(algTree);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree addTree(long userId,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.addTree(userId, name, description,
			serviceContext);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree addTree(long userId,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		boolean disableWorkflow)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.addTree(userId, name, description,
			serviceContext, disableWorkflow);
	}

	/**
	* Creates a new alg tree with the primary key. Does not add the alg tree to the database.
	*
	* @param treeId the primary key for the new alg tree
	* @return the new alg tree
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree createALGTree(
		long treeId) {
		return _algTreeLocalService.createALGTree(treeId);
	}

	/**
	* Deletes the alg tree from the database. Also notifies the appropriate model listeners.
	*
	* @param algTree the alg tree
	* @return the alg tree that was removed
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree deleteALGTree(
		com.nikhilesh.liferay.algorithm.model.ALGTree algTree) {
		return _algTreeLocalService.deleteALGTree(algTree);
	}

	/**
	* Deletes the alg tree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree that was removed
	* @throws PortalException if a alg tree with the primary key could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree deleteALGTree(
		long treeId) throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.deleteALGTree(treeId);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree deleteTree(
		long treeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _algTreeLocalService.deleteTree(treeId, serviceContext);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree fetchALGTree(
		long treeId) {
		return _algTreeLocalService.fetchALGTree(treeId);
	}

	/**
	* Returns the alg tree matching the UUID and group.
	*
	* @param uuid the alg tree's UUID
	* @param groupId the primary key of the group
	* @return the matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree fetchALGTreeByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _algTreeLocalService.fetchALGTreeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the alg tree with the primary key.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree
	* @throws PortalException if a alg tree with the primary key could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree getALGTree(long treeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.getALGTree(treeId);
	}

	/**
	* Returns the alg tree matching the UUID and group.
	*
	* @param uuid the alg tree's UUID
	* @param groupId the primary key of the group
	* @return the matching alg tree
	* @throws PortalException if a matching alg tree could not be found
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree getALGTreeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.getALGTreeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the alg tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param algTree the alg tree
	* @return the alg tree that was updated
	*/
	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree updateALGTree(
		com.nikhilesh.liferay.algorithm.model.ALGTree algTree) {
		return _algTreeLocalService.updateALGTree(algTree);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree updateStatus(
		long userId, long treeId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _algTreeLocalService.updateStatus(userId, treeId, status,
			serviceContext);
	}

	@Override
	public com.nikhilesh.liferay.algorithm.model.ALGTree updateTree(
		long userId, long treeId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _algTreeLocalService.updateTree(userId, treeId, name,
			description, serviceContext);
	}

	/**
	* Returns the number of alg trees.
	*
	* @return the number of alg trees
	*/
	@Override
	public int getALGTreesCount() {
		return _algTreeLocalService.getALGTreesCount();
	}

	@Override
	public int getALGTreesCount(long groupId) {
		return _algTreeLocalService.getALGTreesCount(groupId);
	}

	@Override
	public int getALGTreesCount(long groupId, int status) {
		return _algTreeLocalService.getALGTreesCount(groupId, status);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _algTreeLocalService.getOSGiServiceIdentifier();
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
		return _algTreeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nikhilesh.liferay.algorithm.model.impl.ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _algTreeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nikhilesh.liferay.algorithm.model.impl.ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _algTreeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the alg trees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nikhilesh.liferay.algorithm.model.impl.ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @return the range of alg trees
	*/
	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		int start, int end) {
		return _algTreeLocalService.getALGTrees(start, end);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId) {
		return _algTreeLocalService.getALGTrees(groupId);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int start, int end) {
		return _algTreeLocalService.getALGTrees(groupId, start, end);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.ALGTree> obc) {
		return _algTreeLocalService.getALGTrees(groupId, start, end, obc);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int status) {
		return _algTreeLocalService.getALGTrees(groupId, status);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int status, int start, int end) {
		return _algTreeLocalService.getALGTrees(groupId, status, start, end);
	}

	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.ALGTree> obc) {
		return _algTreeLocalService.getALGTrees(groupId, status, start, end, obc);
	}

	/**
	* Returns all the alg trees matching the UUID and company.
	*
	* @param uuid the UUID of the alg trees
	* @param companyId the primary key of the company
	* @return the matching alg trees, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTreesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _algTreeLocalService.getALGTreesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of alg trees matching the UUID and company.
	*
	* @param uuid the UUID of the alg trees
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching alg trees, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTreesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.ALGTree> orderByComparator) {
		return _algTreeLocalService.getALGTreesByUuidAndCompanyId(uuid,
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
		return _algTreeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _algTreeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ALGTreeLocalService getWrappedService() {
		return _algTreeLocalService;
	}

	@Override
	public void setWrappedService(ALGTreeLocalService algTreeLocalService) {
		_algTreeLocalService = algTreeLocalService;
	}

	private ALGTreeLocalService _algTreeLocalService;
}