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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ALGTree. This utility wraps
 * {@link com.nikhilesh.liferay.algorithm.service.impl.ALGTreeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ALGTreeLocalService
 * @see com.nikhilesh.liferay.algorithm.service.base.ALGTreeLocalServiceBaseImpl
 * @see com.nikhilesh.liferay.algorithm.service.impl.ALGTreeLocalServiceImpl
 * @generated
 */
@ProviderType
public class ALGTreeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.nikhilesh.liferay.algorithm.service.impl.ALGTreeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the alg tree to the database. Also notifies the appropriate model listeners.
	*
	* @param algTree the alg tree
	* @return the alg tree that was added
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree addALGTree(
		com.nikhilesh.liferay.algorithm.model.ALGTree algTree) {
		return getService().addALGTree(algTree);
	}

	public static com.nikhilesh.liferay.algorithm.model.ALGTree addTree(
		long userId, java.lang.String name, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addTree(userId, name, description, serviceContext);
	}

	public static com.nikhilesh.liferay.algorithm.model.ALGTree addTree(
		long userId, java.lang.String name, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		boolean disableWorkflow)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTree(userId, name, description, serviceContext,
			disableWorkflow);
	}

	/**
	* Creates a new alg tree with the primary key. Does not add the alg tree to the database.
	*
	* @param treeId the primary key for the new alg tree
	* @return the new alg tree
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree createALGTree(
		long treeId) {
		return getService().createALGTree(treeId);
	}

	/**
	* Deletes the alg tree from the database. Also notifies the appropriate model listeners.
	*
	* @param algTree the alg tree
	* @return the alg tree that was removed
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree deleteALGTree(
		com.nikhilesh.liferay.algorithm.model.ALGTree algTree) {
		return getService().deleteALGTree(algTree);
	}

	/**
	* Deletes the alg tree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree that was removed
	* @throws PortalException if a alg tree with the primary key could not be found
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree deleteALGTree(
		long treeId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteALGTree(treeId);
	}

	public static com.nikhilesh.liferay.algorithm.model.ALGTree deleteTree(
		long treeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTree(treeId, serviceContext);
	}

	public static com.nikhilesh.liferay.algorithm.model.ALGTree fetchALGTree(
		long treeId) {
		return getService().fetchALGTree(treeId);
	}

	/**
	* Returns the alg tree matching the UUID and group.
	*
	* @param uuid the alg tree's UUID
	* @param groupId the primary key of the group
	* @return the matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree fetchALGTreeByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchALGTreeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the alg tree with the primary key.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree
	* @throws PortalException if a alg tree with the primary key could not be found
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree getALGTree(
		long treeId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getALGTree(treeId);
	}

	/**
	* Returns the alg tree matching the UUID and group.
	*
	* @param uuid the alg tree's UUID
	* @param groupId the primary key of the group
	* @return the matching alg tree
	* @throws PortalException if a matching alg tree could not be found
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree getALGTreeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getALGTreeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the alg tree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param algTree the alg tree
	* @return the alg tree that was updated
	*/
	public static com.nikhilesh.liferay.algorithm.model.ALGTree updateALGTree(
		com.nikhilesh.liferay.algorithm.model.ALGTree algTree) {
		return getService().updateALGTree(algTree);
	}

	public static com.nikhilesh.liferay.algorithm.model.ALGTree updateStatus(
		long userId, long treeId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStatus(userId, treeId, status, serviceContext);
	}

	public static com.nikhilesh.liferay.algorithm.model.ALGTree updateTree(
		long userId, long treeId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateTree(userId, treeId, name, description, serviceContext);
	}

	/**
	* Returns the number of alg trees.
	*
	* @return the number of alg trees
	*/
	public static int getALGTreesCount() {
		return getService().getALGTreesCount();
	}

	public static int getALGTreesCount(long groupId) {
		return getService().getALGTreesCount(groupId);
	}

	public static int getALGTreesCount(long groupId, int status) {
		return getService().getALGTreesCount(groupId, status);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		int start, int end) {
		return getService().getALGTrees(start, end);
	}

	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId) {
		return getService().getALGTrees(groupId);
	}

	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int start, int end) {
		return getService().getALGTrees(groupId, start, end);
	}

	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.ALGTree> obc) {
		return getService().getALGTrees(groupId, start, end, obc);
	}

	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int status) {
		return getService().getALGTrees(groupId, status);
	}

	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int status, int start, int end) {
		return getService().getALGTrees(groupId, status, start, end);
	}

	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTrees(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.ALGTree> obc) {
		return getService().getALGTrees(groupId, status, start, end, obc);
	}

	/**
	* Returns all the alg trees matching the UUID and company.
	*
	* @param uuid the UUID of the alg trees
	* @param companyId the primary key of the company
	* @return the matching alg trees, or an empty list if no matches were found
	*/
	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTreesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getALGTreesByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.nikhilesh.liferay.algorithm.model.ALGTree> getALGTreesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.nikhilesh.liferay.algorithm.model.ALGTree> orderByComparator) {
		return getService()
				   .getALGTreesByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ALGTreeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ALGTreeLocalService, ALGTreeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ALGTreeLocalService.class);
}