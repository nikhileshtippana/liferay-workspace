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
 * This class is a wrapper for {@link ALGTree}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ALGTree
 * @generated
 */
@ProviderType
public class ALGTreeWrapper implements ALGTree, ModelWrapper<ALGTree> {
	public ALGTreeWrapper(ALGTree algTree) {
		_algTree = algTree;
	}

	@Override
	public Class<?> getModelClass() {
		return ALGTree.class;
	}

	@Override
	public String getModelClassName() {
		return ALGTree.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("treeId", getTreeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long treeId = (Long)attributes.get("treeId");

		if (treeId != null) {
			setTreeId(treeId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public ALGTree toEscapedModel() {
		return new ALGTreeWrapper(_algTree.toEscapedModel());
	}

	@Override
	public ALGTree toUnescapedModel() {
		return new ALGTreeWrapper(_algTree.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this alg tree is approved.
	*
	* @return <code>true</code> if this alg tree is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _algTree.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _algTree.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this alg tree is denied.
	*
	* @return <code>true</code> if this alg tree is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _algTree.isDenied();
	}

	/**
	* Returns <code>true</code> if this alg tree is a draft.
	*
	* @return <code>true</code> if this alg tree is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _algTree.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _algTree.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this alg tree is expired.
	*
	* @return <code>true</code> if this alg tree is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _algTree.isExpired();
	}

	/**
	* Returns <code>true</code> if this alg tree is inactive.
	*
	* @return <code>true</code> if this alg tree is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _algTree.isInactive();
	}

	/**
	* Returns <code>true</code> if this alg tree is incomplete.
	*
	* @return <code>true</code> if this alg tree is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _algTree.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _algTree.isNew();
	}

	/**
	* Returns <code>true</code> if this alg tree is pending.
	*
	* @return <code>true</code> if this alg tree is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _algTree.isPending();
	}

	/**
	* Returns <code>true</code> if this alg tree is scheduled.
	*
	* @return <code>true</code> if this alg tree is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _algTree.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _algTree.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ALGTree> toCacheModel() {
		return _algTree.toCacheModel();
	}

	@Override
	public int compareTo(ALGTree algTree) {
		return _algTree.compareTo(algTree);
	}

	/**
	* Returns the status of this alg tree.
	*
	* @return the status of this alg tree
	*/
	@Override
	public int getStatus() {
		return _algTree.getStatus();
	}

	@Override
	public int hashCode() {
		return _algTree.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _algTree.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ALGTreeWrapper((ALGTree)_algTree.clone());
	}

	/**
	* Returns the description of this alg tree.
	*
	* @return the description of this alg tree
	*/
	@Override
	public java.lang.String getDescription() {
		return _algTree.getDescription();
	}

	/**
	* Returns the name of this alg tree.
	*
	* @return the name of this alg tree
	*/
	@Override
	public java.lang.String getName() {
		return _algTree.getName();
	}

	/**
	* Returns the status by user name of this alg tree.
	*
	* @return the status by user name of this alg tree
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _algTree.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this alg tree.
	*
	* @return the status by user uuid of this alg tree
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _algTree.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this alg tree.
	*
	* @return the user name of this alg tree
	*/
	@Override
	public java.lang.String getUserName() {
		return _algTree.getUserName();
	}

	/**
	* Returns the user uuid of this alg tree.
	*
	* @return the user uuid of this alg tree
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _algTree.getUserUuid();
	}

	/**
	* Returns the uuid of this alg tree.
	*
	* @return the uuid of this alg tree
	*/
	@Override
	public java.lang.String getUuid() {
		return _algTree.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _algTree.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _algTree.toXmlString();
	}

	/**
	* Returns the create date of this alg tree.
	*
	* @return the create date of this alg tree
	*/
	@Override
	public Date getCreateDate() {
		return _algTree.getCreateDate();
	}

	/**
	* Returns the modified date of this alg tree.
	*
	* @return the modified date of this alg tree
	*/
	@Override
	public Date getModifiedDate() {
		return _algTree.getModifiedDate();
	}

	/**
	* Returns the status date of this alg tree.
	*
	* @return the status date of this alg tree
	*/
	@Override
	public Date getStatusDate() {
		return _algTree.getStatusDate();
	}

	/**
	* Returns the company ID of this alg tree.
	*
	* @return the company ID of this alg tree
	*/
	@Override
	public long getCompanyId() {
		return _algTree.getCompanyId();
	}

	/**
	* Returns the group ID of this alg tree.
	*
	* @return the group ID of this alg tree
	*/
	@Override
	public long getGroupId() {
		return _algTree.getGroupId();
	}

	/**
	* Returns the primary key of this alg tree.
	*
	* @return the primary key of this alg tree
	*/
	@Override
	public long getPrimaryKey() {
		return _algTree.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this alg tree.
	*
	* @return the status by user ID of this alg tree
	*/
	@Override
	public long getStatusByUserId() {
		return _algTree.getStatusByUserId();
	}

	/**
	* Returns the tree ID of this alg tree.
	*
	* @return the tree ID of this alg tree
	*/
	@Override
	public long getTreeId() {
		return _algTree.getTreeId();
	}

	/**
	* Returns the user ID of this alg tree.
	*
	* @return the user ID of this alg tree
	*/
	@Override
	public long getUserId() {
		return _algTree.getUserId();
	}

	@Override
	public void persist() {
		_algTree.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_algTree.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this alg tree.
	*
	* @param companyId the company ID of this alg tree
	*/
	@Override
	public void setCompanyId(long companyId) {
		_algTree.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this alg tree.
	*
	* @param createDate the create date of this alg tree
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_algTree.setCreateDate(createDate);
	}

	/**
	* Sets the description of this alg tree.
	*
	* @param description the description of this alg tree
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_algTree.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_algTree.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_algTree.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_algTree.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this alg tree.
	*
	* @param groupId the group ID of this alg tree
	*/
	@Override
	public void setGroupId(long groupId) {
		_algTree.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this alg tree.
	*
	* @param modifiedDate the modified date of this alg tree
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_algTree.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this alg tree.
	*
	* @param name the name of this alg tree
	*/
	@Override
	public void setName(java.lang.String name) {
		_algTree.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_algTree.setNew(n);
	}

	/**
	* Sets the primary key of this alg tree.
	*
	* @param primaryKey the primary key of this alg tree
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_algTree.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_algTree.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this alg tree.
	*
	* @param status the status of this alg tree
	*/
	@Override
	public void setStatus(int status) {
		_algTree.setStatus(status);
	}

	/**
	* Sets the status by user ID of this alg tree.
	*
	* @param statusByUserId the status by user ID of this alg tree
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_algTree.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this alg tree.
	*
	* @param statusByUserName the status by user name of this alg tree
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_algTree.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this alg tree.
	*
	* @param statusByUserUuid the status by user uuid of this alg tree
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_algTree.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this alg tree.
	*
	* @param statusDate the status date of this alg tree
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_algTree.setStatusDate(statusDate);
	}

	/**
	* Sets the tree ID of this alg tree.
	*
	* @param treeId the tree ID of this alg tree
	*/
	@Override
	public void setTreeId(long treeId) {
		_algTree.setTreeId(treeId);
	}

	/**
	* Sets the user ID of this alg tree.
	*
	* @param userId the user ID of this alg tree
	*/
	@Override
	public void setUserId(long userId) {
		_algTree.setUserId(userId);
	}

	/**
	* Sets the user name of this alg tree.
	*
	* @param userName the user name of this alg tree
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_algTree.setUserName(userName);
	}

	/**
	* Sets the user uuid of this alg tree.
	*
	* @param userUuid the user uuid of this alg tree
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_algTree.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this alg tree.
	*
	* @param uuid the uuid of this alg tree
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_algTree.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ALGTreeWrapper)) {
			return false;
		}

		ALGTreeWrapper algTreeWrapper = (ALGTreeWrapper)obj;

		if (Objects.equals(_algTree, algTreeWrapper._algTree)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _algTree.getStagedModelType();
	}

	@Override
	public ALGTree getWrappedModel() {
		return _algTree;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _algTree.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _algTree.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_algTree.resetOriginalValues();
	}

	private final ALGTree _algTree;
}