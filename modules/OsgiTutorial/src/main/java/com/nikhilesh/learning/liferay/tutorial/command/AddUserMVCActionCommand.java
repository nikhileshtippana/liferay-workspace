package com.nikhilesh.learning.liferay.tutorial.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;

import com.nikhilesh.learning.liferay.tutorial.constants.OsgiTutorialPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true, property = {
				"javax.portlet.name=" + OsgiTutorialPortletKeys.OsgiTutorial,
				"mvc.command.name=/osgi-tutorial/lexicon/add-user"
		},
		service = MVCActionCommand.class
)
public class AddUserMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		SessionMessages.add(actionRequest, "addUserSuccess");
		actionResponse.setRenderParameter(
			"mvcRenderCommandName", "/osgi-tutorial/lexicon");
	}

}