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
 * Provides a wrapper for {@link ALGTreeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ALGTreeService
 * @generated
 */
@ProviderType
public class ALGTreeServiceWrapper implements ALGTreeService,
	ServiceWrapper<ALGTreeService> {
	public ALGTreeServiceWrapper(ALGTreeService algTreeService) {
		_algTreeService = algTreeService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _algTreeService.getOSGiServiceIdentifier();
	}

	@Override
	public ALGTreeService getWrappedService() {
		return _algTreeService;
	}

	@Override
	public void setWrappedService(ALGTreeService algTreeService) {
		_algTreeService = algTreeService;
	}

	private ALGTreeService _algTreeService;
}