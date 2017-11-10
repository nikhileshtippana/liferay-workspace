package com.nikhilesh.learning.liferay.guestbook.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.nikhilesh.learning.liferay.guestbook.model.Guestbook;
import com.nikhilesh.learning.liferay.guestbook.service.GuestbookLocalServiceUtil;

public class GuestbookPermission {

    public static void check(PermissionChecker permissionChecker, long guestbookId, 
        String actionId) throws PortalException, SystemException {

        if (!contains(permissionChecker, guestbookId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker, long guestbookId, 
        String actionId) throws PortalException, SystemException {

        Guestbook guestbook = GuestbookLocalServiceUtil.getGuestbook(guestbookId);

        return permissionChecker.hasPermission(guestbook.getGroupId(), Guestbook.class.getName(), 
            guestbook.getGuestbookId(), actionId);
    }
}
