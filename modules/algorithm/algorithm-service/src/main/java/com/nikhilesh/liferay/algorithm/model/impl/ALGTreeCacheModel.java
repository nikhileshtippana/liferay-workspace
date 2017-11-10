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

import com.nikhilesh.liferay.algorithm.model.ALGTree;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ALGTree in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ALGTree
 * @generated
 */
@ProviderType
public class ALGTreeCacheModel implements CacheModel<ALGTree>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ALGTreeCacheModel)) {
			return false;
		}

		ALGTreeCacheModel algTreeCacheModel = (ALGTreeCacheModel)obj;

		if (treeId == algTreeCacheModel.treeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, treeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", treeId=");
		sb.append(treeId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ALGTree toEntityModel() {
		ALGTreeImpl algTreeImpl = new ALGTreeImpl();

		if (uuid == null) {
			algTreeImpl.setUuid(StringPool.BLANK);
		}
		else {
			algTreeImpl.setUuid(uuid);
		}

		algTreeImpl.setTreeId(treeId);
		algTreeImpl.setGroupId(groupId);
		algTreeImpl.setCompanyId(companyId);
		algTreeImpl.setUserId(userId);

		if (userName == null) {
			algTreeImpl.setUserName(StringPool.BLANK);
		}
		else {
			algTreeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			algTreeImpl.setCreateDate(null);
		}
		else {
			algTreeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			algTreeImpl.setModifiedDate(null);
		}
		else {
			algTreeImpl.setModifiedDate(new Date(modifiedDate));
		}

		algTreeImpl.setStatus(status);
		algTreeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			algTreeImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			algTreeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			algTreeImpl.setStatusDate(null);
		}
		else {
			algTreeImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			algTreeImpl.setName(StringPool.BLANK);
		}
		else {
			algTreeImpl.setName(name);
		}

		if (description == null) {
			algTreeImpl.setDescription(StringPool.BLANK);
		}
		else {
			algTreeImpl.setDescription(description);
		}

		algTreeImpl.resetOriginalValues();

		return algTreeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		treeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(treeId);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long treeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public String description;
}