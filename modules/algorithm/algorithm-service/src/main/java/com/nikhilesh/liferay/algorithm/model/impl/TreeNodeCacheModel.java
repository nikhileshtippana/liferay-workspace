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

package com.nikhilesh.liferay.algorithm.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.nikhilesh.liferay.algorithm.model.TreeNode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TreeNode in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TreeNode
 * @generated
 */
@ProviderType
public class TreeNodeCacheModel implements CacheModel<TreeNode>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TreeNodeCacheModel)) {
			return false;
		}

		TreeNodeCacheModel treeNodeCacheModel = (TreeNodeCacheModel)obj;

		if (treeNodeId == treeNodeCacheModel.treeNodeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, treeNodeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", treeNodeId=");
		sb.append(treeNodeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", value=");
		sb.append(value);
		sb.append(", level=");
		sb.append(level);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", treeId=");
		sb.append(treeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TreeNode toEntityModel() {
		TreeNodeImpl treeNodeImpl = new TreeNodeImpl();

		if (uuid == null) {
			treeNodeImpl.setUuid(StringPool.BLANK);
		}
		else {
			treeNodeImpl.setUuid(uuid);
		}

		treeNodeImpl.setTreeNodeId(treeNodeId);
		treeNodeImpl.setGroupId(groupId);
		treeNodeImpl.setCompanyId(companyId);
		treeNodeImpl.setUserId(userId);

		if (userName == null) {
			treeNodeImpl.setUserName(StringPool.BLANK);
		}
		else {
			treeNodeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			treeNodeImpl.setCreateDate(null);
		}
		else {
			treeNodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			treeNodeImpl.setModifiedDate(null);
		}
		else {
			treeNodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		treeNodeImpl.setValue(value);
		treeNodeImpl.setLevel(level);
		treeNodeImpl.setParentId(parentId);
		treeNodeImpl.setTreeId(treeId);

		treeNodeImpl.resetOriginalValues();

		return treeNodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		treeNodeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		value = objectInput.readInt();

		level = objectInput.readInt();

		parentId = objectInput.readLong();

		treeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(treeNodeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(value);

		objectOutput.writeInt(level);

		objectOutput.writeLong(parentId);

		objectOutput.writeLong(treeId);
	}

	public String uuid;
	public long treeNodeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int value;
	public int level;
	public long parentId;
	public long treeId;
}