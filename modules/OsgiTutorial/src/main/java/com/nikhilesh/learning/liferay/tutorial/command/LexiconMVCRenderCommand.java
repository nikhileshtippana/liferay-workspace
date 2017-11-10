package com.nikhilesh.learning.liferay.tutorial.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import com.nikhilesh.learning.liferay.tutorial.constants.OsgiTutorialPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + OsgiTutorialPortletKeys.OsgiTutorial,
			"mvc.command.name=/osgi-tutorial/lexicon"
		},
		service = MVCRenderCommand.class
)
public class LexiconMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/lexicon.jsp";
	}

}