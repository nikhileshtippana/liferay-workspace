package com.nikhilesh.learning.liferay.guestbook.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.nikhilesh.learning.liferay.guestbook.model.Entry;
import com.nikhilesh.learning.liferay.guestbook.service.EntryLocalServiceUtil;

public class EntryPermission {

    public static void check(PermissionChecker permissionChecker, long entryId, 
        String actionId) throws PortalException, SystemException {

        if (!contains(permissionChecker, entryId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker, long entryId, 
        String actionId) throws PortalException, SystemException {

        Entry entry = EntryLocalServiceUtil.getEntry(entryId);

        return permissionChecker.hasPermission(entry.getGroupId(), Entry.class.getName(), 
            entry.getEntryId(), actionId);
    }

    public static boolean containsAny(PermissionChecker permissionChecker, long entryId, 
        String... actionIds) throws PortalException, SystemException {

	    for (String actionId : actionIds) { 
	    		boolean contains = contains(permissionChecker, entryId, actionId);
	    		if (contains) {
	    			return true;
	    		}
	    }

        return false;
    }
}
