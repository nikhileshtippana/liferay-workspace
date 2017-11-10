package com.nikhilesh.learning.liferay.tutorial.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.nikhilesh.learning.liferay.tutorial.constants.OsgiTutorialPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author nik
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Nikhilesh",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OsgiTutorial Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OsgiTutorialPortletKeys.OsgiTutorial,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OsgiTutorialPortlet extends MVCPortlet {
}