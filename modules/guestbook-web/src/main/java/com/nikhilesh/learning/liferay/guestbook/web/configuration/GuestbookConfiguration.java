package com.nikhilesh.learning.liferay.guestbook.web.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.nikhilesh.learning.liferay.guestbook.web.configuration.GuestbookConfiguration")
public interface GuestbookConfiguration {

	@Meta.AD(
        deflt = "blue",
        required = false
    )
    public String favoriteColor();

    @Meta.AD(
       deflt = "red|green|blue",
       required = false
    )
    public String[] validColors();

    @Meta.AD(
        deflt = "10",
        required = false
    )
    public int itemsPerPage();
	
}
