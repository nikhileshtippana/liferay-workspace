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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.nikhilesh.liferay.algorithm.service.http.TreeNodeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.nikhilesh.liferay.algorithm.service.http.TreeNodeServiceSoap
 * @generated
 */
@ProviderType
public class TreeNodeSoap implements Serializable {
	public static TreeNodeSoap toSoapModel(TreeNode model) {
		TreeNodeSoap soapModel = new TreeNodeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTreeNodeId(model.getTreeNodeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setValue(model.getValue());
		soapModel.setLevel(model.getLevel());
		soapModel.setParentId(model.getParentId());
		soapModel.setTreeId(model.getTreeId());

		return soapModel;
	}

	public static TreeNodeSoap[] toSoapModels(TreeNode[] models) {
		TreeNodeSoap[] soapModels = new TreeNodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TreeNodeSoap[][] toSoapModels(TreeNode[][] models) {
		TreeNodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TreeNodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TreeNodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TreeNodeSoap[] toSoapModels(List<TreeNode> models) {
		List<TreeNodeSoap> soapModels = new ArrayList<TreeNodeSoap>(models.size());

		for (TreeNode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TreeNodeSoap[soapModels.size()]);
	}

	public TreeNodeSoap() {
	}

	public long getPrimaryKey() {
		return _treeNodeId;
	}

	public void setPrimaryKey(long pk) {
		setTreeNodeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTreeNodeId() {
		return _treeNodeId;
	}

	public void setTreeNodeId(long treeNodeId) {
		_treeNodeId = treeNodeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public long getTreeId() {
		return _treeId;
	}

	public void setTreeId(long treeId) {
		_treeId = treeId;
	}

	private String _uuid;
	private long _treeNodeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _value;
	private int _level;
	private long _parentId;
	private long _treeId;
}