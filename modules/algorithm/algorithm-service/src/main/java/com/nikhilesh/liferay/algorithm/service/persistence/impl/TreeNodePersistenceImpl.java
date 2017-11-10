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

package com.nikhilesh.liferay.algorithm.service.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.nikhilesh.liferay.algorithm.exception.NoSuchTreeNodeException;
import com.nikhilesh.liferay.algorithm.model.TreeNode;
import com.nikhilesh.liferay.algorithm.model.impl.TreeNodeImpl;
import com.nikhilesh.liferay.algorithm.model.impl.TreeNodeModelImpl;
import com.nikhilesh.liferay.algorithm.service.persistence.TreeNodePersistence;

import aQute.bnd.annotation.ProviderType;

/**
 * The persistence implementation for the tree node service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreeNodePersistence
 * @see com.nikhilesh.liferay.algorithm.service.persistence.TreeNodeUtil
 * @generated
 */
@ProviderType
public class TreeNodePersistenceImpl extends BasePersistenceImpl<TreeNode>
	implements TreeNodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TreeNodeUtil} to access the tree node persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TreeNodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TreeNodeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tree nodes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tree nodes
	 */
	@Override
	public List<TreeNode> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreeNode> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<TreeNode> findByUuid(String uuid, int start, int end,
		OrderByComparator<TreeNode> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<TreeNode> findByUuid(String uuid, int start, int end,
		OrderByComparator<TreeNode> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<TreeNode> list = null;

		if (retrieveFromCache) {
			list = (List<TreeNode>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreeNode treeNode : list) {
					if (!Objects.equals(uuid, treeNode.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TREENODE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tree node in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tree node
	 * @throws NoSuchTreeNodeException if a matching tree node could not be found
	 */
	@Override
	public TreeNode findByUuid_First(String uuid,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByUuid_First(uuid, orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
	}

	/**
	 * Returns the first tree node in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByUuid_First(String uuid,
		OrderByComparator<TreeNode> orderByComparator) {
		List<TreeNode> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tree node in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tree node
	 * @throws NoSuchTreeNodeException if a matching tree node could not be found
	 */
	@Override
	public TreeNode findByUuid_Last(String uuid,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByUuid_Last(uuid, orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
	}

	/**
	 * Returns the last tree node in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByUuid_Last(String uuid,
		OrderByComparator<TreeNode> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TreeNode> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreeNode[] findByUuid_PrevAndNext(long treeNodeId, String uuid,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = findByPrimaryKey(treeNodeId);

		Session session = null;

		try {
			session = openSession();

			TreeNode[] array = new TreeNodeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, treeNode, uuid,
					orderByComparator, true);

			array[1] = treeNode;

			array[2] = getByUuid_PrevAndNext(session, treeNode, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreeNode getByUuid_PrevAndNext(Session session,
		TreeNode treeNode, String uuid,
		OrderByComparator<TreeNode> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TREENODE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(treeNode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TreeNode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tree nodes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TreeNode treeNode : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(treeNode);
		}
	}

	/**
	 * Returns the number of tree nodes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tree nodes
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TREENODE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "treeNode.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "treeNode.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(treeNode.uuid IS NULL OR treeNode.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TreeNodeModelImpl.UUID_COLUMN_BITMASK |
			TreeNodeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the tree node where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTreeNodeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tree node
	 * @throws NoSuchTreeNodeException if a matching tree node could not be found
	 */
	@Override
	public TreeNode findByUUID_G(String uuid, long groupId)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByUUID_G(uuid, groupId);

		if (treeNode == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTreeNodeException(msg.toString());
		}

		return treeNode;
	}

	/**
	 * Returns the tree node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tree node where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof TreeNode) {
			TreeNode treeNode = (TreeNode)result;

			if (!Objects.equals(uuid, treeNode.getUuid()) ||
					(groupId != treeNode.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TREENODE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<TreeNode> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					TreeNode treeNode = list.get(0);

					result = treeNode;

					cacheResult(treeNode);

					if ((treeNode.getUuid() == null) ||
							!treeNode.getUuid().equals(uuid) ||
							(treeNode.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, treeNode);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TreeNode)result;
		}
	}

	/**
	 * Removes the tree node where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tree node that was removed
	 */
	@Override
	public TreeNode removeByUUID_G(String uuid, long groupId)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = findByUUID_G(uuid, groupId);

		return remove(treeNode);
	}

	/**
	 * Returns the number of tree nodes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tree nodes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TREENODE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "treeNode.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "treeNode.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(treeNode.uuid IS NULL OR treeNode.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "treeNode.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TreeNodeModelImpl.UUID_COLUMN_BITMASK |
			TreeNodeModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the tree nodes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tree nodes
	 */
	@Override
	public List<TreeNode> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreeNode> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<TreeNode> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<TreeNode> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<TreeNode> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TreeNode> list = null;

		if (retrieveFromCache) {
			list = (List<TreeNode>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreeNode treeNode : list) {
					if (!Objects.equals(uuid, treeNode.getUuid()) ||
							(companyId != treeNode.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TREENODE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TreeNode findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
	}

	/**
	 * Returns the first tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<TreeNode> orderByComparator) {
		List<TreeNode> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreeNode findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
	}

	/**
	 * Returns the last tree node in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<TreeNode> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TreeNode> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreeNode[] findByUuid_C_PrevAndNext(long treeNodeId, String uuid,
		long companyId, OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = findByPrimaryKey(treeNodeId);

		Session session = null;

		try {
			session = openSession();

			TreeNode[] array = new TreeNodeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, treeNode, uuid,
					companyId, orderByComparator, true);

			array[1] = treeNode;

			array[2] = getByUuid_C_PrevAndNext(session, treeNode, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreeNode getByUuid_C_PrevAndNext(Session session,
		TreeNode treeNode, String uuid, long companyId,
		OrderByComparator<TreeNode> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TREENODE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(treeNode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TreeNode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tree nodes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TreeNode treeNode : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(treeNode);
		}
	}

	/**
	 * Returns the number of tree nodes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tree nodes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TREENODE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "treeNode.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "treeNode.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(treeNode.uuid IS NULL OR treeNode.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "treeNode.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T",
			new String[] { Long.class.getName(), Long.class.getName() },
			TreeNodeModelImpl.GROUPID_COLUMN_BITMASK |
			TreeNodeModelImpl.TREEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the tree nodes where groupId = &#63; and treeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 * @return the matching tree nodes
	 */
	@Override
	public List<TreeNode> findByG_T(long groupId, long treeId) {
		return findByG_T(groupId, treeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TreeNode> findByG_T(long groupId, long treeId, int start,
		int end) {
		return findByG_T(groupId, treeId, start, end, null);
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
	@Override
	public List<TreeNode> findByG_T(long groupId, long treeId, int start,
		int end, OrderByComparator<TreeNode> orderByComparator) {
		return findByG_T(groupId, treeId, start, end, orderByComparator, true);
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
	@Override
	public List<TreeNode> findByG_T(long groupId, long treeId, int start,
		int end, OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] { groupId, treeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] {
					groupId, treeId,
					
					start, end, orderByComparator
				};
		}

		List<TreeNode> list = null;

		if (retrieveFromCache) {
			list = (List<TreeNode>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreeNode treeNode : list) {
					if ((groupId != treeNode.getGroupId()) ||
							(treeId != treeNode.getTreeId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TREENODE_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TREEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(treeId);

				if (!pagination) {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TreeNode findByG_T_First(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByG_T_First(groupId, treeId, orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", treeId=");
		msg.append(treeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
	}

	/**
	 * Returns the first tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByG_T_First(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator) {
		List<TreeNode> list = findByG_T(groupId, treeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreeNode findByG_T_Last(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByG_T_Last(groupId, treeId, orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", treeId=");
		msg.append(treeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
	}

	/**
	 * Returns the last tree node in the ordered set where groupId = &#63; and treeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tree node, or <code>null</code> if a matching tree node could not be found
	 */
	@Override
	public TreeNode fetchByG_T_Last(long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator) {
		int count = countByG_T(groupId, treeId);

		if (count == 0) {
			return null;
		}

		List<TreeNode> list = findByG_T(groupId, treeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreeNode[] findByG_T_PrevAndNext(long treeNodeId, long groupId,
		long treeId, OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = findByPrimaryKey(treeNodeId);

		Session session = null;

		try {
			session = openSession();

			TreeNode[] array = new TreeNodeImpl[3];

			array[0] = getByG_T_PrevAndNext(session, treeNode, groupId, treeId,
					orderByComparator, true);

			array[1] = treeNode;

			array[2] = getByG_T_PrevAndNext(session, treeNode, groupId, treeId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreeNode getByG_T_PrevAndNext(Session session, TreeNode treeNode,
		long groupId, long treeId,
		OrderByComparator<TreeNode> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TREENODE_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_TREEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(treeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(treeNode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TreeNode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tree nodes where groupId = &#63; and treeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 */
	@Override
	public void removeByG_T(long groupId, long treeId) {
		for (TreeNode treeNode : findByG_T(groupId, treeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(treeNode);
		}
	}

	/**
	 * Returns the number of tree nodes where groupId = &#63; and treeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 * @return the number of matching tree nodes
	 */
	@Override
	public int countByG_T(long groupId, long treeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T;

		Object[] finderArgs = new Object[] { groupId, treeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TREENODE_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TREEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(treeId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "treeNode.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_TREEID_2 = "treeNode.treeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T_L = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_T_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T_L = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, TreeNodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TreeNodeModelImpl.GROUPID_COLUMN_BITMASK |
			TreeNodeModelImpl.TREEID_COLUMN_BITMASK |
			TreeNodeModelImpl.LEVEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T_L = new FinderPath(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 * @param level the level
	 * @return the matching tree nodes
	 */
	@Override
	public List<TreeNode> findByG_T_L(long groupId, long treeId, int level) {
		return findByG_T_L(groupId, treeId, level, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreeNode> findByG_T_L(long groupId, long treeId, int level,
		int start, int end) {
		return findByG_T_L(groupId, treeId, level, start, end, null);
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
	@Override
	public List<TreeNode> findByG_T_L(long groupId, long treeId, int level,
		int start, int end, OrderByComparator<TreeNode> orderByComparator) {
		return findByG_T_L(groupId, treeId, level, start, end,
			orderByComparator, true);
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
	@Override
	public List<TreeNode> findByG_T_L(long groupId, long treeId, int level,
		int start, int end, OrderByComparator<TreeNode> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T_L;
			finderArgs = new Object[] { groupId, treeId, level };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T_L;
			finderArgs = new Object[] {
					groupId, treeId, level,
					
					start, end, orderByComparator
				};
		}

		List<TreeNode> list = null;

		if (retrieveFromCache) {
			list = (List<TreeNode>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreeNode treeNode : list) {
					if ((groupId != treeNode.getGroupId()) ||
							(treeId != treeNode.getTreeId()) ||
							(level != treeNode.getLevel())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TREENODE_WHERE);

			query.append(_FINDER_COLUMN_G_T_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_L_TREEID_2);

			query.append(_FINDER_COLUMN_G_T_L_LEVEL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(treeId);

				qPos.add(level);

				if (!pagination) {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TreeNode findByG_T_L_First(long groupId, long treeId, int level,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByG_T_L_First(groupId, treeId, level,
				orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", treeId=");
		msg.append(treeId);

		msg.append(", level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
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
	@Override
	public TreeNode fetchByG_T_L_First(long groupId, long treeId, int level,
		OrderByComparator<TreeNode> orderByComparator) {
		List<TreeNode> list = findByG_T_L(groupId, treeId, level, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreeNode findByG_T_L_Last(long groupId, long treeId, int level,
		OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByG_T_L_Last(groupId, treeId, level,
				orderByComparator);

		if (treeNode != null) {
			return treeNode;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", treeId=");
		msg.append(treeId);

		msg.append(", level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTreeNodeException(msg.toString());
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
	@Override
	public TreeNode fetchByG_T_L_Last(long groupId, long treeId, int level,
		OrderByComparator<TreeNode> orderByComparator) {
		int count = countByG_T_L(groupId, treeId, level);

		if (count == 0) {
			return null;
		}

		List<TreeNode> list = findByG_T_L(groupId, treeId, level, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreeNode[] findByG_T_L_PrevAndNext(long treeNodeId, long groupId,
		long treeId, int level, OrderByComparator<TreeNode> orderByComparator)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = findByPrimaryKey(treeNodeId);

		Session session = null;

		try {
			session = openSession();

			TreeNode[] array = new TreeNodeImpl[3];

			array[0] = getByG_T_L_PrevAndNext(session, treeNode, groupId,
					treeId, level, orderByComparator, true);

			array[1] = treeNode;

			array[2] = getByG_T_L_PrevAndNext(session, treeNode, groupId,
					treeId, level, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreeNode getByG_T_L_PrevAndNext(Session session,
		TreeNode treeNode, long groupId, long treeId, int level,
		OrderByComparator<TreeNode> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_TREENODE_WHERE);

		query.append(_FINDER_COLUMN_G_T_L_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_L_TREEID_2);

		query.append(_FINDER_COLUMN_G_T_L_LEVEL_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TreeNodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(treeId);

		qPos.add(level);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(treeNode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TreeNode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tree nodes where groupId = &#63; and treeId = &#63; and level = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 * @param level the level
	 */
	@Override
	public void removeByG_T_L(long groupId, long treeId, int level) {
		for (TreeNode treeNode : findByG_T_L(groupId, treeId, level,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(treeNode);
		}
	}

	/**
	 * Returns the number of tree nodes where groupId = &#63; and treeId = &#63; and level = &#63;.
	 *
	 * @param groupId the group ID
	 * @param treeId the tree ID
	 * @param level the level
	 * @return the number of matching tree nodes
	 */
	@Override
	public int countByG_T_L(long groupId, long treeId, int level) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T_L;

		Object[] finderArgs = new Object[] { groupId, treeId, level };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TREENODE_WHERE);

			query.append(_FINDER_COLUMN_G_T_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_L_TREEID_2);

			query.append(_FINDER_COLUMN_G_T_L_LEVEL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(treeId);

				qPos.add(level);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_T_L_GROUPID_2 = "treeNode.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_L_TREEID_2 = "treeNode.treeId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_L_LEVEL_2 = "treeNode.level = ?";

	public TreeNodePersistenceImpl() {
		setModelClass(TreeNode.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the tree node in the entity cache if it is enabled.
	 *
	 * @param treeNode the tree node
	 */
	@Override
	public void cacheResult(TreeNode treeNode) {
		entityCache.putResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeImpl.class, treeNode.getPrimaryKey(), treeNode);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { treeNode.getUuid(), treeNode.getGroupId() }, treeNode);

		treeNode.resetOriginalValues();
	}

	/**
	 * Caches the tree nodes in the entity cache if it is enabled.
	 *
	 * @param treeNodes the tree nodes
	 */
	@Override
	public void cacheResult(List<TreeNode> treeNodes) {
		for (TreeNode treeNode : treeNodes) {
			if (entityCache.getResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
						TreeNodeImpl.class, treeNode.getPrimaryKey()) == null) {
				cacheResult(treeNode);
			}
			else {
				treeNode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tree nodes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TreeNodeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tree node.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TreeNode treeNode) {
		entityCache.removeResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeImpl.class, treeNode.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TreeNodeModelImpl)treeNode, true);
	}

	@Override
	public void clearCache(List<TreeNode> treeNodes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TreeNode treeNode : treeNodes) {
			entityCache.removeResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
				TreeNodeImpl.class, treeNode.getPrimaryKey());

			clearUniqueFindersCache((TreeNodeModelImpl)treeNode, true);
		}
	}

	protected void cacheUniqueFindersCache(TreeNodeModelImpl treeNodeModelImpl) {
		Object[] args = new Object[] {
				treeNodeModelImpl.getUuid(), treeNodeModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			treeNodeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TreeNodeModelImpl treeNodeModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					treeNodeModelImpl.getUuid(), treeNodeModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((treeNodeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					treeNodeModelImpl.getOriginalUuid(),
					treeNodeModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new tree node with the primary key. Does not add the tree node to the database.
	 *
	 * @param treeNodeId the primary key for the new tree node
	 * @return the new tree node
	 */
	@Override
	public TreeNode create(long treeNodeId) {
		TreeNode treeNode = new TreeNodeImpl();

		treeNode.setNew(true);
		treeNode.setPrimaryKey(treeNodeId);

		String uuid = PortalUUIDUtil.generate();

		treeNode.setUuid(uuid);

		treeNode.setCompanyId(companyProvider.getCompanyId());

		return treeNode;
	}

	/**
	 * Removes the tree node with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param treeNodeId the primary key of the tree node
	 * @return the tree node that was removed
	 * @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	 */
	@Override
	public TreeNode remove(long treeNodeId) throws NoSuchTreeNodeException {
		return remove((Serializable)treeNodeId);
	}

	/**
	 * Removes the tree node with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tree node
	 * @return the tree node that was removed
	 * @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	 */
	@Override
	public TreeNode remove(Serializable primaryKey)
		throws NoSuchTreeNodeException {
		Session session = null;

		try {
			session = openSession();

			TreeNode treeNode = (TreeNode)session.get(TreeNodeImpl.class,
					primaryKey);

			if (treeNode == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTreeNodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(treeNode);
		}
		catch (NoSuchTreeNodeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TreeNode removeImpl(TreeNode treeNode) {
		treeNode = toUnwrappedModel(treeNode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(treeNode)) {
				treeNode = (TreeNode)session.get(TreeNodeImpl.class,
						treeNode.getPrimaryKeyObj());
			}

			if (treeNode != null) {
				session.delete(treeNode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (treeNode != null) {
			clearCache(treeNode);
		}

		return treeNode;
	}

	@Override
	public TreeNode updateImpl(TreeNode treeNode) {
		treeNode = toUnwrappedModel(treeNode);

		boolean isNew = treeNode.isNew();

		TreeNodeModelImpl treeNodeModelImpl = (TreeNodeModelImpl)treeNode;

		if (Validator.isNull(treeNode.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			treeNode.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (treeNode.getCreateDate() == null)) {
			if (serviceContext == null) {
				treeNode.setCreateDate(now);
			}
			else {
				treeNode.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!treeNodeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				treeNode.setModifiedDate(now);
			}
			else {
				treeNode.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (treeNode.isNew()) {
				session.save(treeNode);

				treeNode.setNew(false);
			}
			else {
				treeNode = (TreeNode)session.merge(treeNode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TreeNodeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { treeNodeModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					treeNodeModelImpl.getUuid(),
					treeNodeModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					treeNodeModelImpl.getGroupId(),
					treeNodeModelImpl.getTreeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
				args);

			args = new Object[] {
					treeNodeModelImpl.getGroupId(),
					treeNodeModelImpl.getTreeId(), treeNodeModelImpl.getLevel()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_T_L, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T_L,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((treeNodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { treeNodeModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { treeNodeModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((treeNodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						treeNodeModelImpl.getOriginalUuid(),
						treeNodeModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						treeNodeModelImpl.getUuid(),
						treeNodeModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((treeNodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						treeNodeModelImpl.getOriginalGroupId(),
						treeNodeModelImpl.getOriginalTreeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);

				args = new Object[] {
						treeNodeModelImpl.getGroupId(),
						treeNodeModelImpl.getTreeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);
			}

			if ((treeNodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						treeNodeModelImpl.getOriginalGroupId(),
						treeNodeModelImpl.getOriginalTreeId(),
						treeNodeModelImpl.getOriginalLevel()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_T_L, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T_L,
					args);

				args = new Object[] {
						treeNodeModelImpl.getGroupId(),
						treeNodeModelImpl.getTreeId(),
						treeNodeModelImpl.getLevel()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_T_L, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T_L,
					args);
			}
		}

		entityCache.putResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
			TreeNodeImpl.class, treeNode.getPrimaryKey(), treeNode, false);

		clearUniqueFindersCache(treeNodeModelImpl, false);
		cacheUniqueFindersCache(treeNodeModelImpl);

		treeNode.resetOriginalValues();

		return treeNode;
	}

	protected TreeNode toUnwrappedModel(TreeNode treeNode) {
		if (treeNode instanceof TreeNodeImpl) {
			return treeNode;
		}

		TreeNodeImpl treeNodeImpl = new TreeNodeImpl();

		treeNodeImpl.setNew(treeNode.isNew());
		treeNodeImpl.setPrimaryKey(treeNode.getPrimaryKey());

		treeNodeImpl.setUuid(treeNode.getUuid());
		treeNodeImpl.setTreeNodeId(treeNode.getTreeNodeId());
		treeNodeImpl.setGroupId(treeNode.getGroupId());
		treeNodeImpl.setCompanyId(treeNode.getCompanyId());
		treeNodeImpl.setUserId(treeNode.getUserId());
		treeNodeImpl.setUserName(treeNode.getUserName());
		treeNodeImpl.setCreateDate(treeNode.getCreateDate());
		treeNodeImpl.setModifiedDate(treeNode.getModifiedDate());
		treeNodeImpl.setValue(treeNode.getValue());
		treeNodeImpl.setLevel(treeNode.getLevel());
		treeNodeImpl.setParentId(treeNode.getParentId());
		treeNodeImpl.setTreeId(treeNode.getTreeId());

		return treeNodeImpl;
	}

	/**
	 * Returns the tree node with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tree node
	 * @return the tree node
	 * @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	 */
	@Override
	public TreeNode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTreeNodeException {
		TreeNode treeNode = fetchByPrimaryKey(primaryKey);

		if (treeNode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTreeNodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return treeNode;
	}

	/**
	 * Returns the tree node with the primary key or throws a {@link NoSuchTreeNodeException} if it could not be found.
	 *
	 * @param treeNodeId the primary key of the tree node
	 * @return the tree node
	 * @throws NoSuchTreeNodeException if a tree node with the primary key could not be found
	 */
	@Override
	public TreeNode findByPrimaryKey(long treeNodeId)
		throws NoSuchTreeNodeException {
		return findByPrimaryKey((Serializable)treeNodeId);
	}

	/**
	 * Returns the tree node with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tree node
	 * @return the tree node, or <code>null</code> if a tree node with the primary key could not be found
	 */
	@Override
	public TreeNode fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
				TreeNodeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TreeNode treeNode = (TreeNode)serializable;

		if (treeNode == null) {
			Session session = null;

			try {
				session = openSession();

				treeNode = (TreeNode)session.get(TreeNodeImpl.class, primaryKey);

				if (treeNode != null) {
					cacheResult(treeNode);
				}
				else {
					entityCache.putResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
						TreeNodeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
					TreeNodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return treeNode;
	}

	/**
	 * Returns the tree node with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param treeNodeId the primary key of the tree node
	 * @return the tree node, or <code>null</code> if a tree node with the primary key could not be found
	 */
	@Override
	public TreeNode fetchByPrimaryKey(long treeNodeId) {
		return fetchByPrimaryKey((Serializable)treeNodeId);
	}

	@Override
	public Map<Serializable, TreeNode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TreeNode> map = new HashMap<Serializable, TreeNode>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TreeNode treeNode = fetchByPrimaryKey(primaryKey);

			if (treeNode != null) {
				map.put(primaryKey, treeNode);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
					TreeNodeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TreeNode)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TREENODE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TreeNode treeNode : (List<TreeNode>)q.list()) {
				map.put(treeNode.getPrimaryKeyObj(), treeNode);

				cacheResult(treeNode);

				uncachedPrimaryKeys.remove(treeNode.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TreeNodeModelImpl.ENTITY_CACHE_ENABLED,
					TreeNodeImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the tree nodes.
	 *
	 * @return the tree nodes
	 */
	@Override
	public List<TreeNode> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreeNode> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TreeNode> findAll(int start, int end,
		OrderByComparator<TreeNode> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TreeNode> findAll(int start, int end,
		OrderByComparator<TreeNode> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TreeNode> list = null;

		if (retrieveFromCache) {
			list = (List<TreeNode>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TREENODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TREENODE;

				if (pagination) {
					sql = sql.concat(TreeNodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TreeNode>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tree nodes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TreeNode treeNode : findAll()) {
			remove(treeNode);
		}
	}

	/**
	 * Returns the number of tree nodes.
	 *
	 * @return the number of tree nodes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TREENODE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TreeNodeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tree node persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TreeNodeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TREENODE = "SELECT treeNode FROM TreeNode treeNode";
	private static final String _SQL_SELECT_TREENODE_WHERE_PKS_IN = "SELECT treeNode FROM TreeNode treeNode WHERE treeNodeId IN (";
	private static final String _SQL_SELECT_TREENODE_WHERE = "SELECT treeNode FROM TreeNode treeNode WHERE ";
	private static final String _SQL_COUNT_TREENODE = "SELECT COUNT(treeNode) FROM TreeNode treeNode";
	private static final String _SQL_COUNT_TREENODE_WHERE = "SELECT COUNT(treeNode) FROM TreeNode treeNode WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "treeNode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TreeNode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TreeNode exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TreeNodePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final Serializable nullModel = null;
}