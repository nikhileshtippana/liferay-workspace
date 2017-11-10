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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.nikhilesh.liferay.algorithm.exception.NoSuchALGTreeException;
import com.nikhilesh.liferay.algorithm.model.ALGTree;

/**
 * The persistence interface for the alg tree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.nikhilesh.liferay.algorithm.service.persistence.impl.ALGTreePersistenceImpl
 * @see ALGTreeUtil
 * @generated
 */
@ProviderType
public interface ALGTreePersistence extends BasePersistence<ALGTree> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ALGTreeUtil} to access the alg tree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the alg trees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching alg trees
	*/
	public java.util.List<ALGTree> findByUuid(java.lang.String uuid);

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
	public java.util.List<ALGTree> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<ALGTree> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

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
	public java.util.List<ALGTree> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

	/**
	* Returns the alg trees before and after the current alg tree in the ordered set where uuid = &#63;.
	*
	* @param treeId the primary key of the current alg tree
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public ALGTree[] findByUuid_PrevAndNext(long treeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Removes all the alg trees where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of alg trees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching alg trees
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the alg tree where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchALGTreeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchALGTreeException;

	/**
	* Returns the alg tree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the alg tree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the alg tree where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the alg tree that was removed
	*/
	public ALGTree removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchALGTreeException;

	/**
	* Returns the number of alg trees where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching alg trees
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the alg trees where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching alg trees
	*/
	public java.util.List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

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
	public java.util.List<ALGTree> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the first alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the last alg tree in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

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
	public ALGTree[] findByUuid_C_PrevAndNext(long treeId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Removes all the alg trees where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of alg trees where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching alg trees
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the alg trees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching alg trees
	*/
	public java.util.List<ALGTree> findByGroup(long groupId);

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
	public java.util.List<ALGTree> findByGroup(long groupId, int start, int end);

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
	public java.util.List<ALGTree> findByGroup(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

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
	public java.util.List<ALGTree> findByGroup(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

	/**
	* Returns the alg trees before and after the current alg tree in the ordered set where groupId = &#63;.
	*
	* @param treeId the primary key of the current alg tree
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public ALGTree[] findByGroup_PrevAndNext(long treeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Removes all the alg trees where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroup(long groupId);

	/**
	* Returns the number of alg trees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching alg trees
	*/
	public int countByGroup(long groupId);

	/**
	* Returns all the alg trees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching alg trees
	*/
	public java.util.List<ALGTree> findByG_S(long groupId, int status);

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
	public java.util.List<ALGTree> findByG_S(long groupId, int status,
		int start, int end);

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
	public java.util.List<ALGTree> findByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

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
	public java.util.List<ALGTree> findByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the first alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree
	* @throws NoSuchALGTreeException if a matching alg tree could not be found
	*/
	public ALGTree findByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Returns the last alg tree in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alg tree, or <code>null</code> if a matching alg tree could not be found
	*/
	public ALGTree fetchByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

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
	public ALGTree[] findByG_S_PrevAndNext(long treeId, long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator)
		throws NoSuchALGTreeException;

	/**
	* Removes all the alg trees where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeByG_S(long groupId, int status);

	/**
	* Returns the number of alg trees where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching alg trees
	*/
	public int countByG_S(long groupId, int status);

	/**
	* Caches the alg tree in the entity cache if it is enabled.
	*
	* @param algTree the alg tree
	*/
	public void cacheResult(ALGTree algTree);

	/**
	* Caches the alg trees in the entity cache if it is enabled.
	*
	* @param algTrees the alg trees
	*/
	public void cacheResult(java.util.List<ALGTree> algTrees);

	/**
	* Creates a new alg tree with the primary key. Does not add the alg tree to the database.
	*
	* @param treeId the primary key for the new alg tree
	* @return the new alg tree
	*/
	public ALGTree create(long treeId);

	/**
	* Removes the alg tree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree that was removed
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public ALGTree remove(long treeId) throws NoSuchALGTreeException;

	public ALGTree updateImpl(ALGTree algTree);

	/**
	* Returns the alg tree with the primary key or throws a {@link NoSuchALGTreeException} if it could not be found.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree
	* @throws NoSuchALGTreeException if a alg tree with the primary key could not be found
	*/
	public ALGTree findByPrimaryKey(long treeId) throws NoSuchALGTreeException;

	/**
	* Returns the alg tree with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param treeId the primary key of the alg tree
	* @return the alg tree, or <code>null</code> if a alg tree with the primary key could not be found
	*/
	public ALGTree fetchByPrimaryKey(long treeId);

	@Override
	public java.util.Map<java.io.Serializable, ALGTree> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the alg trees.
	*
	* @return the alg trees
	*/
	public java.util.List<ALGTree> findAll();

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
	public java.util.List<ALGTree> findAll(int start, int end);

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
	public java.util.List<ALGTree> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator);

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
	public java.util.List<ALGTree> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ALGTree> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the alg trees from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of alg trees.
	*
	* @return the number of alg trees
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}