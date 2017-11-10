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

package com.nikhilesh.liferay.algorithm.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.nikhilesh.liferay.algorithm.model.TreeNode;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tree node service. This utility wraps {@link com.nikhilesh.liferay.algorithm.service.persistence.impl.TreeNodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreeNodePersistence
 * @see com.nikhilesh.liferay.algorithm.service.persistence.impl.TreeNodePersistenceImpl
 * @generated
 */
@ProviderType
public class TreeNodeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TreeNode treeNode) {
		getPersistence().clearCache(treeNode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TreeNode> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TreeNode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TreeNode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TreeNode update(TreeNode treeNode) {
		return getPersistence().update(treeNode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TreeNode update(TreeNode treeNode,
		ServiceContext serviceContext) {
		return getPersistence().update(treeNode, serviceContext);
	}

	/**
	* Returns all the tree nodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching tree nodes
	*/
	public static List<TreeNode> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the tree nodes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @return the range of matching tree nodes
	*/
	public static List<TreeNode> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the tree nodes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tree nodes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByUuid_First(java.lang.String uuid,
		OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByUuid_Last(java.lang.String uuid,
		OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the tree nodes before and after the current tree node in the ordered set where uuid = &#63;.
	*
	* @param treeNodeId the primary key of the current tree node
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tree node
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public static TreeNode[] findByUuid_PrevAndNext(long treeNodeId,
		java.lang.String uuid, OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(treeNodeId, uuid, orderByComparator);
	}

	/**
	* Removes all the tree nodes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of tree nodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching tree nodes
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the tree node where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTreeNodeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByUUID_G(java.lang.String uuid, long groupId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the tree node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the tree node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the tree node where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the tree node that was removed
	*/
	public static TreeNode removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of tree nodes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching tree nodes
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the tree nodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching tree nodes
	*/
	public static List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the tree nodes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @return the range of matching tree nodes
	*/
	public static List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the tree nodes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tree nodes where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<TreeNode> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the tree nodes before and after the current tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param treeNodeId the primary key of the current tree node
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tree node
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public static TreeNode[] findByUuid_C_PrevAndNext(long treeNodeId,
		java.lang.String uuid, long companyId,
		OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(treeNodeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the tree nodes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of tree nodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching tree nodes
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the tree nodes where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @return the matching tree nodes
	*/
	public static List<TreeNode> findByG_T(long groupId, long treeId) {
		return getPersistence().findByG_T(groupId, treeId);
	}

	/**
	* Returns a range of all the tree nodes where groupId = &#63; and treeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @return the range of matching tree nodes
	*/
	public static List<TreeNode> findByG_T(long groupId, long treeId,
		int start, int end) {
		return getPersistence().findByG_T(groupId, treeId, start, end);
	}

	/**
	* Returns an ordered range of all the tree nodes where groupId = &#63; and treeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByG_T(long groupId, long treeId,
		int start, int end, OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .findByG_T(groupId, treeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tree nodes where groupId = &#63; and treeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByG_T(long groupId, long treeId,
		int start, int end, OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_T(groupId, treeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByG_T_First(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByG_T_First(groupId, treeId, orderByComparator);
	}

	/**
	* Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByG_T_First(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .fetchByG_T_First(groupId, treeId, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByG_T_Last(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByG_T_Last(groupId, treeId, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByG_T_Last(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .fetchByG_T_Last(groupId, treeId, orderByComparator);
	}

	/**
	* Returns the tree nodes before and after the current tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param treeNodeId the primary key of the current tree node
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tree node
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public static TreeNode[] findByG_T_PrevAndNext(long treeNodeId,
		long groupId, long treeId, OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByG_T_PrevAndNext(treeNodeId, groupId, treeId,
			orderByComparator);
	}

	/**
	* Removes all the tree nodes where groupId = &#63; and treeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	*/
	public static void removeByG_T(long groupId, long treeId) {
		getPersistence().removeByG_T(groupId, treeId);
	}

	/**
	* Returns the number of tree nodes where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @return the number of matching tree nodes
	*/
	public static int countByG_T(long groupId, long treeId) {
		return getPersistence().countByG_T(groupId, treeId);
	}

	/**
	* Returns all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @return the matching tree nodes
	*/
	public static List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level) {
		return getPersistence().findByG_T_L(groupId, treeId, level);
	}

	/**
	* Returns a range of all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @return the range of matching tree nodes
	*/
	public static List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level, int start, int end) {
		return getPersistence().findByG_T_L(groupId, treeId, level, start, end);
	}

	/**
	* Returns an ordered range of all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level, int start, int end,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .findByG_T_L(groupId, treeId, level, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tree nodes
	*/
	public static List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level, int start, int end,
		OrderByComparator<TreeNode> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_T_L(groupId, treeId, level, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByG_T_L_First(long groupId, long treeId,
		int level, OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByG_T_L_First(groupId, treeId, level, orderByComparator);
	}

	/**
	* Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByG_T_L_First(long groupId, long treeId,
		int level, OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .fetchByG_T_L_First(groupId, treeId, level, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public static TreeNode findByG_T_L_Last(long groupId, long treeId,
		int level, OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByG_T_L_Last(groupId, treeId, level, orderByComparator);
	}

	/**
	* Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public static TreeNode fetchByG_T_L_Last(long groupId, long treeId,
		int level, OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence()
				   .fetchByG_T_L_Last(groupId, treeId, level, orderByComparator);
	}

	/**
	* Returns the tree nodes before and after the current tree node in the ordered set where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param treeNodeId the primary key of the current tree node
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tree node
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public static TreeNode[] findByG_T_L_PrevAndNext(long treeNodeId,
		long groupId, long treeId, int level,
		OrderByComparator<TreeNode> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence()
				   .findByG_T_L_PrevAndNext(treeNodeId, groupId, treeId, level,
			orderByComparator);
	}

	/**
	* Removes all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63; from the database.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	*/
	public static void removeByG_T_L(long groupId, long treeId, int level) {
		getPersistence().removeByG_T_L(groupId, treeId, level);
	}

	/**
	* Returns the number of tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @return the number of matching tree nodes
	*/
	public static int countByG_T_L(long groupId, long treeId, int level) {
		return getPersistence().countByG_T_L(groupId, treeId, level);
	}

	/**
	* Caches the tree node in the entity cache if it is enabled.
	*
	* @param treeNode the tree node
	*/
	public static void cacheResult(TreeNode treeNode) {
		getPersistence().cacheResult(treeNode);
	}

	/**
	* Caches the tree nodes in the entity cache if it is enabled.
	*
	* @param treeNodes the tree nodes
	*/
	public static void cacheResult(List<TreeNode> treeNodes) {
		getPersistence().cacheResult(treeNodes);
	}

	/**
	* Creates a new tree node with the primary key. Does not add the tree node to the database.
	*
	* @param treeNodeId the primary key for the new tree node
	* @return the new tree node
	*/
	public static TreeNode create(long treeNodeId) {
		return getPersistence().create(treeNodeId);
	}

	/**
	* Removes the tree node with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node that was removed
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public static TreeNode remove(long treeNodeId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence().remove(treeNodeId);
	}

	public static TreeNode updateImpl(TreeNode treeNode) {
		return getPersistence().updateImpl(treeNode);
	}

	/**
	* Returns the tree node with the primary key or throws a {@link NoSuchTreeNodeException} if it could not be found.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public static TreeNode findByPrimaryKey(long treeNodeId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException {
		return getPersistence().findByPrimaryKey(treeNodeId);
	}

	/**
	* Returns the tree node with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node, or <code>null</code> if a tree node with the primary key could not be found
	*/
	public static TreeNode fetchByPrimaryKey(long treeNodeId) {
		return getPersistence().fetchByPrimaryKey(treeNodeId);
	}

	public static java.util.Map<java.io.Serializable, TreeNode> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tree nodes.
	*
	* @return the tree nodes
	*/
	public static List<TreeNode> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tree nodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @return the range of tree nodes
	*/
	public static List<TreeNode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tree nodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tree nodes
	*/
	public static List<TreeNode> findAll(int start, int end,
		OrderByComparator<TreeNode> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tree nodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TreeNodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tree nodes
	* @param end the upper bound of the range of tree nodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tree nodes
	*/
	public static List<TreeNode> findAll(int start, int end,
		OrderByComparator<TreeNode> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tree nodes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tree nodes.
	*
	* @return the number of tree nodes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TreeNodePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TreeNodePersistence, TreeNodePersistence> _serviceTracker =
		ServiceTrackerFactory.open(TreeNodePersistence.class);
}