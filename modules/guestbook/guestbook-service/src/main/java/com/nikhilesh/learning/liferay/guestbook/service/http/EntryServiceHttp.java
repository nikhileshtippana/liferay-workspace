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

package com.nikhilesh.learning.liferay.guestbook.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.nikhilesh.learning.liferay.guestbook.service.EntryServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link EntryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author nik
 * @see EntryServiceSoap
 * @see HttpPrincipal
 * @see EntryServiceUtil
 * @generated
 */
@ProviderType
public class EntryServiceHttp {
	public static java.util.List<com.nikhilesh.learning.liferay.guestbook.model.Entry> getEntries(
		HttpPrincipal httpPrincipal, long groupId, long guestbookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(EntryServiceUtil.class,
					"getEntries", _getEntriesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					guestbookId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.nikhilesh.learning.liferay.guestbook.model.Entry>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.nikhilesh.learning.liferay.guestbook.model.Entry> getEntries(
		HttpPrincipal httpPrincipal, long groupId, long guestbookId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(EntryServiceUtil.class,
					"getEntries", _getEntriesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					guestbookId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.nikhilesh.learning.liferay.guestbook.model.Entry>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getEntriesCount(HttpPrincipal httpPrincipal,
		long groupId, long guestbookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(EntryServiceUtil.class,
					"getEntriesCount", _getEntriesCountParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					guestbookId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.nikhilesh.learning.liferay.guestbook.model.Entry addEntry(
		HttpPrincipal httpPrincipal, long userId, long guestbookId,
		java.lang.String name, java.lang.String email,
		java.lang.String message,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(EntryServiceUtil.class,
					"addEntry", _addEntryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					guestbookId, name, email, message, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.nikhilesh.learning.liferay.guestbook.model.Entry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.nikhilesh.learning.liferay.guestbook.model.Entry updateEntry(
		HttpPrincipal httpPrincipal, long userId, long guestbookId,
		long entryId, java.lang.String name, java.lang.String email,
		java.lang.String message,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(EntryServiceUtil.class,
					"updateEntry", _updateEntryParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					guestbookId, entryId, name, email, message, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.nikhilesh.learning.liferay.guestbook.model.Entry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.nikhilesh.learning.liferay.guestbook.model.Entry deleteEntry(
		HttpPrincipal httpPrincipal, long entryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(EntryServiceUtil.class,
					"deleteEntry", _deleteEntryParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, entryId,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.nikhilesh.learning.liferay.guestbook.model.Entry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EntryServiceHttp.class);
	private static final Class<?>[] _getEntriesParameterTypes0 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getEntriesParameterTypes1 = new Class[] {
			long.class, long.class, int.class, int.class
		};
	private static final Class<?>[] _getEntriesCountParameterTypes2 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _addEntryParameterTypes3 = new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateEntryParameterTypes4 = new Class[] {
			long.class, long.class, long.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteEntryParameterTypes5 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
}