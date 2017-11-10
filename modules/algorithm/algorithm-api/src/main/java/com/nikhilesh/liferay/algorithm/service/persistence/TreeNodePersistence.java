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

import com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException;
import com.nikhilesh.liferay.algorithm.model.TreeNode;

/**
 * The persistence interface for the tree node service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.nikhilesh.liferay.algorithm.service.persistence.impl.TreeNodePersistenceImpl
 * @see TreeNodeUtil
 * @generated
 */
@ProviderType
public interface TreeNodePersistence extends BasePersistence<TreeNode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TreeNodeUtil} to access the tree node persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tree nodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching tree nodes
	*/
	public java.util.List<TreeNode> findByUuid(java.lang.String uuid);

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
	public java.util.List<TreeNode> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<TreeNode> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public java.util.List<TreeNode> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public TreeNode findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the first tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

	/**
	* Returns the last tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public TreeNode findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the last tree node in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

	/**
	* Returns the tree nodes before and after the current tree node in the ordered set where uuid = &#63;.
	*
	* @param treeNodeId the primary key of the current tree node
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tree node
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public TreeNode[] findByUuid_PrevAndNext(long treeNodeId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Removes all the tree nodes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of tree nodes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching tree nodes
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the tree node where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTreeNodeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public TreeNode findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTreeNodeException;

	/**
	* Returns the tree node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the tree node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the tree node where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the tree node that was removed
	*/
	public TreeNode removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTreeNodeException;

	/**
	* Returns the number of tree nodes where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching tree nodes
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the tree nodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching tree nodes
	*/
	public java.util.List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public java.util.List<TreeNode> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public TreeNode findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the first tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

	/**
	* Returns the last tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public TreeNode findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the last tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public TreeNode[] findByUuid_C_PrevAndNext(long treeNodeId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Removes all the tree nodes where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of tree nodes where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching tree nodes
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the tree nodes where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @return the matching tree nodes
	*/
	public java.util.List<TreeNode> findByG_T(long groupId, long treeId);

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
	public java.util.List<TreeNode> findByG_T(long groupId, long treeId,
		int start, int end);

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
	public java.util.List<TreeNode> findByG_T(long groupId, long treeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public java.util.List<TreeNode> findByG_T(long groupId, long treeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public TreeNode findByG_T_First(long groupId, long treeId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByG_T_First(long groupId, long treeId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

	/**
	* Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node
	* @throws NoSuchTreeNodeException if a matching tree node could not be found
	*/
	public TreeNode findByG_T_Last(long groupId, long treeId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByG_T_Last(long groupId, long treeId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public TreeNode[] findByG_T_PrevAndNext(long treeNodeId, long groupId,
		long treeId,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Removes all the tree nodes where groupId = &#63; and treeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	*/
	public void removeByG_T(long groupId, long treeId);

	/**
	* Returns the number of tree nodes where groupId = &#63; and treeId = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @return the number of matching tree nodes
	*/
	public int countByG_T(long groupId, long treeId);

	/**
	* Returns all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @return the matching tree nodes
	*/
	public java.util.List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level);

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
	public java.util.List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level, int start, int end);

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
	public java.util.List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public java.util.List<TreeNode> findByG_T_L(long groupId, long treeId,
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache);

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
	public TreeNode findByG_T_L_First(long groupId, long treeId, int level,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByG_T_L_First(long groupId, long treeId, int level,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public TreeNode findByG_T_L_Last(long groupId, long treeId, int level,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	*/
	public TreeNode fetchByG_T_L_Last(long groupId, long treeId, int level,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public TreeNode[] findByG_T_L_PrevAndNext(long treeNodeId, long groupId,
		long treeId, int level,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException;

	/**
	* Removes all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63; from the database.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	*/
	public void removeByG_T_L(long groupId, long treeId, int level);

	/**
	* Returns the number of tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	*
	* @param groupId the group ID
	* @param treeId the tree ID
	* @param level the level
	* @return the number of matching tree nodes
	*/
	public int countByG_T_L(long groupId, long treeId, int level);

	/**
	* Caches the tree node in the entity cache if it is enabled.
	*
	* @param treeNode the tree node
	*/
	public void cacheResult(TreeNode treeNode);

	/**
	* Caches the tree nodes in the entity cache if it is enabled.
	*
	* @param treeNodes the tree nodes
	*/
	public void cacheResult(java.util.List<TreeNode> treeNodes);

	/**
	* Creates a new tree node with the primary key. Does not add the tree node to the database.
	*
	* @param treeNodeId the primary key for the new tree node
	* @return the new tree node
	*/
	public TreeNode create(long treeNodeId);

	/**
	* Removes the tree node with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node that was removed
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public TreeNode remove(long treeNodeId) throws NoSuchTreeNodeException;

	public TreeNode updateImpl(TreeNode treeNode);

	/**
	* Returns the tree node with the primary key or throws a {@link NoSuchTreeNodeException} if it could not be found.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node
	* @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	*/
	public TreeNode findByPrimaryKey(long treeNodeId)
		throws NoSuchTreeNodeException;

	/**
	* Returns the tree node with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param treeNodeId the primary key of the tree node
	* @return the tree node, or <code>null</code> if a tree node with the primary key could not be found
	*/
	public TreeNode fetchByPrimaryKey(long treeNodeId);

	@Override
	public java.util.Map<java.io.Serializable, TreeNode> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tree nodes.
	*
	* @return the tree nodes
	*/
	public java.util.List<TreeNode> findAll();

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
	public java.util.List<TreeNode> findAll(int start, int end);

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
	public java.util.List<TreeNode> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator);

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
	public java.util.List<TreeNode> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tree nodes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tree nodes.
	*
	* @return the number of tree nodes
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}