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

package com.nikhilesh.learning.liferay.guestbook.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.nikhilesh.learning.liferay.guestbook.model.Entry;
import com.nikhilesh.learning.liferay.guestbook.service.base.EntryServiceBaseImpl;

/**
 * The implementation of the entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nikhilesh.learning.liferay.guestbook.service.EntryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nik
 * @see EntryServiceBaseImpl
 * @see com.nikhilesh.learning.liferay.guestbook.service.EntryServiceUtil
 */
public class EntryServiceImpl extends EntryServiceBaseImpl {
	
	public List<Entry> getEntries(long groupId, long guestbookId)
			throws SystemException {

		return entryLocalService.getEntries(groupId, guestbookId);
	}

	public List<Entry> getEntries(long groupId, long guestbookId, int start,
			int end) throws SystemException {

		return entryLocalService.getEntries(groupId, guestbookId, start, end);
	}

	public int getEntriesCount(long groupId, long guestbookId)
			throws SystemException {

		return entryLocalService.getEntriesCount(groupId, guestbookId);
	}

	public Entry addEntry(long userId, long guestbookId, String name,
			String email, String message, ServiceContext serviceContext)
					throws PortalException, SystemException {

		return entryLocalService.addEntry(userId, guestbookId, name, email,
				message, serviceContext);
	}

	public Entry updateEntry(long userId, long guestbookId, long entryId,
			String name, String email, String message,
			ServiceContext serviceContext) throws PortalException,
	SystemException {

		return entryLocalService.updateEntry(userId, guestbookId, entryId,
				name, email, message, serviceContext);
	}

	public Entry deleteEntry(long entryId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		return entryLocalService.deleteEntry(entryId, serviceContext);
	}
}