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

package com.nikhilesh.liferay.algorithm.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TreeNodeService}.
 *
 * @author Brian Wing Shun Chan
 * @see TreeNodeService
 * @generated
 */
@ProviderType
public class TreeNodeServiceWrapper implements TreeNodeService,
	ServiceWrapper<TreeNodeService> {
	public TreeNodeServiceWrapper(TreeNodeService treeNodeService) {
		_treeNodeService = treeNodeService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _treeNodeService.getOSGiServiceIdentifier();
	}

	@Override
	public TreeNodeService getWrappedService() {
		return _treeNodeService;
	}

	@Override
	public void setWrappedService(TreeNodeService treeNodeService) {
		_treeNodeService = treeNodeService;
	}

	private TreeNodeService _treeNodeService;
}