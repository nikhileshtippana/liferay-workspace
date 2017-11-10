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

import com.nikhilesh.liferay.algorithm.model.ALGTree;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the alg tree service. This utility wraps {@link com.nikhilesh.liferay.algorithm.service.persistence.impl.ALGTreePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ALGTreePersistence
 * @see com.nikhilesh.liferay.algorithm.service.persistence.impl.ALGTreePersistenceImpl
 * @generated
 */
@ProviderType
public class ALGTreeUtil {
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
	public static void clearCache(ALGTree algTree) {
		getPersistence().clearCache(algTree);
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
	public static List<ALGTree> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ALGTree> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ALGTree> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ALGTree update(ALGTree algTree) {
		return getPersistence().update(algTree);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ALGTree update(ALGTree algTree, ServiceContext serviceContext) {
		return getPersistence().update(algTree, serviceContext);
	}

	/**
	* Returns all the alg trees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching alg trees
	*/
	public static List<ALGTree> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the alg trees where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @return the range of matching alg trees
	*/
	public static List<ALGTree> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the alg trees where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the alg trees where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<ALGTree> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByUuid_First(java.lang.String uuid,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByUuid_Last(java.lang.String uuid,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the alg trees before and after the current alg tree in the ordered set where uuid = &#63;.
	*
	* @param treeId the primary key of the current alg tree
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public static ALGTree[] findByUuid_PrevAndNext(long treeId,
		java.lang.String uuid, OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(treeId, uuid, orderByComparator);
	}

	/**
	* Removes all the alg trees where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of alg trees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching alg trees
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the alg tree where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchALGTreeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByUUID_G(java.lang.String uuid, long groupId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the alg tree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the alg tree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the alg tree where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the alg tree that was removed
	*/
	public static ALGTree removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of alg trees where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching alg trees
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the alg trees where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching alg trees
	*/
	public static List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the alg trees where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @return the range of matching alg trees
	*/
	public static List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the alg trees where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the alg trees where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ALGTree> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the alg trees before and after the current alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param treeId the primary key of the current alg tree
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public static ALGTree[] findByUuid_C_PrevAndNext(long treeId,
		java.lang.String uuid, long companyId,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(treeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the alg trees where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of alg trees where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching alg trees
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the alg trees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching alg trees
	*/
	public static List<ALGTree> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the alg trees where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @return the range of matching alg trees
	*/
	public static List<ALGTree> findByGroup(long groupId, int start, int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the alg trees where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByGroup(long groupId, int start, int end,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the alg trees where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByGroup(long groupId, int start, int end,
		OrderByComparator<ALGTree> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByGroup_First(long groupId,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByGroup_First(long groupId,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByGroup_Last(long groupId,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByGroup_Last(long groupId,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the alg trees before and after the current alg tree in the ordered set where groupId = &#63;.
	*
	* @param treeId the primary key of the current alg tree
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public static ALGTree[] findByGroup_PrevAndNext(long treeId, long groupId,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByGroup_PrevAndNext(treeId, groupId, orderByComparator);
	}

	/**
	* Removes all the alg trees where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of alg trees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching alg trees
	*/
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns all the alg trees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching alg trees
	*/
	public static List<ALGTree> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	* Returns a range of all the alg trees where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @return the range of matching alg trees
	*/
	public static List<ALGTree> findByG_S(long groupId, int status, int start,
		int end) {
		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the alg trees where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the alg trees where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching alg trees
	*/
	public static List<ALGTree> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator<ALGTree> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByG_S_First(long groupId, int status,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByG_S_First(long groupId, int status,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public static ALGTree findByG_S_Last(long groupId, int status,
		OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public static ALGTree fetchByG_S_Last(long groupId, int status,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the alg trees before and after the current alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param treeId the primary key of the current alg tree
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public static ALGTree[] findByG_S_PrevAndNext(long treeId, long groupId,
		int status, OrderByComparator<ALGTree> orderByComparator)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence()
				   .findByG_S_PrevAndNext(treeId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the alg trees where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	* Returns the number of alg trees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching alg trees
	*/
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	* Caches the alg tree in the entity cache if it is enabled.
	*
	* @param algTree the alg tree
	*/
	public static void cacheResult(ALGTree algTree) {
		getPersistence().cacheResult(algTree);
	}

	/**
	* Caches the alg trees in the entity cache if it is enabled.
	*
	* @param algTrees the alg trees
	*/
	public static void cacheResult(List<ALGTree> algTrees) {
		getPersistence().cacheResult(algTrees);
	}

	/**
	* Creates a new alg tree with the primary key. Does not add the alg tree to the database.
	*
	* @param treeId the primary key for the new alg tree
	* @return the new alg tree
	*/
	public static ALGTree create(long treeId) {
		return getPersistence().create(treeId);
	}

	/**
	* Removes the alg tree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree that was removed
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public static ALGTree remove(long treeId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().remove(treeId);
	}

	public static ALGTree updateImpl(ALGTree algTree) {
		return getPersistence().updateImpl(algTree);
	}

	/**
	* Returns the alg tree with the primary key or throws a {@link NoSuchALGTreeException} if it could not be found.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public static ALGTree findByPrimaryKey(long treeId)
		throws com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException {
		return getPersistence().findByPrimaryKey(treeId);
	}

	/**
	* Returns the alg tree with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree, or <code>null</code> if a alg tree with the primary key could not be found
	*/
	public static ALGTree fetchByPrimaryKey(long treeId) {
		return getPersistence().fetchByPrimaryKey(treeId);
	}

	public static java.util.Map<java.io.Serializable, ALGTree> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the alg trees.
	*
	* @return the alg trees
	*/
	public static List<ALGTree> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the alg trees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @return the range of alg trees
	*/
	public static List<ALGTree> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the alg trees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of alg trees
	*/
	public static List<ALGTree> findAll(int start, int end,
		OrderByComparator<ALGTree> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the alg trees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ALGTreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alg trees
	* @param end the upper bound of the range of alg trees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of alg trees
	*/
	public static List<ALGTree> findAll(int start, int end,
		OrderByComparator<ALGTree> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the alg trees from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of alg trees.
	*
	* @return the number of alg trees
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ALGTreePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ALGTreePersistence, ALGTreePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ALGTreePersistence.class);
}