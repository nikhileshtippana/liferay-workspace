package com.nikhilesh.learning.liferay.guestbook.mapper;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.nikhilesh.learning.liferay.guestbook.web.constants.GuestbookPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
        "javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK,
        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml"
    },
    service = FriendlyURLMapper.class
)
public class GuestbookWebFriendlyUrlMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "guestbook";

}