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

package com.nikhilesh.liferay.algorithm.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TreeNode}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreeNode
 * @generated
 */
@ProviderType
public class TreeNodeWrapper implements TreeNode, ModelWrapper<TreeNode> {
	public TreeNodeWrapper(TreeNode treeNode) {
		_treeNode = treeNode;
	}

	@Override
	public Class<?> getModelClass() {
		return TreeNode.class;
	}

	@Override
	public String getModelClassName() {
		return TreeNode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("treeNodeId", getTreeNodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("value", getValue());
		attributes.put("level", getLevel());
		attributes.put("parentId", getParentId());
		attributes.put("treeId", getTreeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long treeNodeId = (Long)attributes.get("treeNodeId");

		if (treeNodeId != null) {
			setTreeNodeId(treeNodeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Long treeId = (Long)attributes.get("treeId");

		if (treeId != null) {
			setTreeId(treeId);
		}
	}

	@Override
	public TreeNode toEscapedModel() {
		return new TreeNodeWrapper(_treeNode.toEscapedModel());
	}

	@Override
	public TreeNode toUnescapedModel() {
		return new TreeNodeWrapper(_treeNode.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _treeNode.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _treeNode.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _treeNode.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _treeNode.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TreeNode> toCacheModel() {
		return _treeNode.toCacheModel();
	}

	@Override
	public int compareTo(TreeNode treeNode) {
		return _treeNode.compareTo(treeNode);
	}

	/**
	* Returns the level of this tree node.
	*
	* @return the level of this tree node
	*/
	@Override
	public int getLevel() {
		return _treeNode.getLevel();
	}

	/**
	* Returns the value of this tree node.
	*
	* @return the value of this tree node
	*/
	@Override
	public int getValue() {
		return _treeNode.getValue();
	}

	@Override
	public int hashCode() {
		return _treeNode.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _treeNode.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TreeNodeWrapper((TreeNode)_treeNode.clone());
	}

	/**
	* Returns the user name of this tree node.
	*
	* @return the user name of this tree node
	*/
	@Override
	public java.lang.String getUserName() {
		return _treeNode.getUserName();
	}

	/**
	* Returns the user uuid of this tree node.
	*
	* @return the user uuid of this tree node
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _treeNode.getUserUuid();
	}

	/**
	* Returns the uuid of this tree node.
	*
	* @return the uuid of this tree node
	*/
	@Override
	public java.lang.String getUuid() {
		return _treeNode.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _treeNode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _treeNode.toXmlString();
	}

	/**
	* Returns the create date of this tree node.
	*
	* @return the create date of this tree node
	*/
	@Override
	public Date getCreateDate() {
		return _treeNode.getCreateDate();
	}

	/**
	* Returns the modified date of this tree node.
	*
	* @return the modified date of this tree node
	*/
	@Override
	public Date getModifiedDate() {
		return _treeNode.getModifiedDate();
	}

	/**
	* Returns the company ID of this tree node.
	*
	* @return the company ID of this tree node
	*/
	@Override
	public long getCompanyId() {
		return _treeNode.getCompanyId();
	}

	/**
	* Returns the group ID of this tree node.
	*
	* @return the group ID of this tree node
	*/
	@Override
	public long getGroupId() {
		return _treeNode.getGroupId();
	}

	/**
	* Returns the parent ID of this tree node.
	*
	* @return the parent ID of this tree node
	*/
	@Override
	public long getParentId() {
		return _treeNode.getParentId();
	}

	/**
	* Returns the primary key of this tree node.
	*
	* @return the primary key of this tree node
	*/
	@Override
	public long getPrimaryKey() {
		return _treeNode.getPrimaryKey();
	}

	/**
	* Returns the tree ID of this tree node.
	*
	* @return the tree ID of this tree node
	*/
	@Override
	public long getTreeId() {
		return _treeNode.getTreeId();
	}

	/**
	* Returns the tree node ID of this tree node.
	*
	* @return the tree node ID of this tree node
	*/
	@Override
	public long getTreeNodeId() {
		return _treeNode.getTreeNodeId();
	}

	/**
	* Returns the user ID of this tree node.
	*
	* @return the user ID of this tree node
	*/
	@Override
	public long getUserId() {
		return _treeNode.getUserId();
	}

	@Override
	public void persist() {
		_treeNode.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_treeNode.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this tree node.
	*
	* @param companyId the company ID of this tree node
	*/
	@Override
	public void setCompanyId(long companyId) {
		_treeNode.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this tree node.
	*
	* @param createDate the create date of this tree node
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_treeNode.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_treeNode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_treeNode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_treeNode.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this tree node.
	*
	* @param groupId the group ID of this tree node
	*/
	@Override
	public void setGroupId(long groupId) {
		_treeNode.setGroupId(groupId);
	}

	/**
	* Sets the level of this tree node.
	*
	* @param level the level of this tree node
	*/
	@Override
	public void setLevel(int level) {
		_treeNode.setLevel(level);
	}

	/**
	* Sets the modified date of this tree node.
	*
	* @param modifiedDate the modified date of this tree node
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_treeNode.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_treeNode.setNew(n);
	}

	/**
	* Sets the parent ID of this tree node.
	*
	* @param parentId the parent ID of this tree node
	*/
	@Override
	public void setParentId(long parentId) {
		_treeNode.setParentId(parentId);
	}

	/**
	* Sets the primary key of this tree node.
	*
	* @param primaryKey the primary key of this tree node
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_treeNode.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_treeNode.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tree ID of this tree node.
	*
	* @param treeId the tree ID of this tree node
	*/
	@Override
	public void setTreeId(long treeId) {
		_treeNode.setTreeId(treeId);
	}

	/**
	* Sets the tree node ID of this tree node.
	*
	* @param treeNodeId the tree node ID of this tree node
	*/
	@Override
	public void setTreeNodeId(long treeNodeId) {
		_treeNode.setTreeNodeId(treeNodeId);
	}

	/**
	* Sets the user ID of this tree node.
	*
	* @param userId the user ID of this tree node
	*/
	@Override
	public void setUserId(long userId) {
		_treeNode.setUserId(userId);
	}

	/**
	* Sets the user name of this tree node.
	*
	* @param userName the user name of this tree node
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_treeNode.setUserName(userName);
	}

	/**
	* Sets the user uuid of this tree node.
	*
	* @param userUuid the user uuid of this tree node
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_treeNode.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this tree node.
	*
	* @param uuid the uuid of this tree node
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_treeNode.setUuid(uuid);
	}

	/**
	* Sets the value of this tree node.
	*
	* @param value the value of this tree node
	*/
	@Override
	public void setValue(int value) {
		_treeNode.setValue(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TreeNodeWrapper)) {
			return false;
		}

		TreeNodeWrapper treeNodeWrapper = (TreeNodeWrapper)obj;

		if (Objects.equals(_treeNode, treeNodeWrapper._treeNode)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _treeNode.getStagedModelType();
	}

	@Override
	public TreeNode getWrappedModel() {
		return _treeNode;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _treeNode.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _treeNode.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_treeNode.resetOriginalValues();
	}

	private final TreeNode _treeNode;
}