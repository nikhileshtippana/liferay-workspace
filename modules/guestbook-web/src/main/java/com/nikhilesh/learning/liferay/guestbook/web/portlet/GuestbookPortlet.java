package com.nikhilesh.learning.liferay.guestbook.web.portlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.nikhilesh.learning.liferay.guestbook.model.Entry;
import com.nikhilesh.learning.liferay.guestbook.model.Guestbook;
import com.nikhilesh.learning.liferay.guestbook.service.EntryLocalService;
import com.nikhilesh.learning.liferay.guestbook.service.GuestbookLocalService;
import com.nikhilesh.learning.liferay.guestbook.web.configuration.GuestbookConfiguration;
import com.nikhilesh.learning.liferay.guestbook.web.constants.GuestbookPortletKeys;

/**
 * @author nik
 */
@Component(
	    configurationPid = "com.nikhilesh.learning.liferay.guestbook.web.configuration.GuestbookConfiguration",
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.nikapps",
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.scopeable=true",
			"com.liferay.portlet.css-class-wrapper=guestbook",
			"javax.portlet.display-name=Guestbook",
			"javax.portlet.expiration-cache=60",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/guestbookwebportlet/view.jsp",
			"javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supports.mime-type=text/html"
		},
		service = Portlet.class
)
public class GuestbookPortlet extends MVCPortlet {

	public void deleteEntry(ActionRequest request, ActionResponse response)
		throws PortalException {

		long entryId = ParamUtil.getLong(request, "entryId");
		String redirectURL = ParamUtil.getString(request, "redirect");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Entry.class.getName(), request);

		try {
			_entryLocalService.deleteEntry(entryId, serviceContext);
			
			SessionMessages.add(request, "entryDeleted");

			response.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			Logger.getLogger(
				Guestbook.class.getName()).log(Level.SEVERE, null, e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Guestbook.class.getName(), renderRequest);

			long groupId = serviceContext.getScopeGroupId();

			long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");

			List<Guestbook> guestbooks = _guestbookLocalService.getGuestbooks(
				groupId, WorkflowConstants.STATUS_APPROVED);

			if (guestbooks.isEmpty()) {
				Guestbook guestbook = _guestbookLocalService.addGuestbook(
						serviceContext.getUserId(), "Main", serviceContext,
						true);

				guestbookId = guestbook.getGuestbookId();
			}

			if (guestbookId == 0) {
				guestbookId = guestbooks.get(0).getGuestbookId();
			}

			renderRequest.setAttribute("guestbookId", guestbookId);
			
			renderRequest.setAttribute(GuestbookConfiguration.class.getName(), _configuration);

			User user = PortalUtil.getUser(renderRequest);

			_log.info("Rendered by " + user.getFullName());
		}
		catch (Exception e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}

	public void saveEntry(ActionRequest request, ActionResponse response)
		throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Entry.class.getName(), request);

		String userName = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		String message = ParamUtil.getString(request, "message");
		long guestbookId = ParamUtil.getLong(request, "guestbookId");
		long entryId = ParamUtil.getLong(request, "entryId");
		String redirectURL = ParamUtil.getString(request, "redirect");

		if (entryId > 0) {
			try {
				_entryLocalService.updateEntry(
					serviceContext.getUserId(), guestbookId, entryId, userName,
					email, message, serviceContext);

				SessionMessages.add(request, "entryUpdated");

				response.sendRedirect(redirectURL);
			}
			catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter(
					"mvcPath", "/guestbookwebportlet/edit_entry.jsp");
			}
		}
		else {
			try {
				_entryLocalService.addEntry(
					serviceContext.getUserId(), guestbookId, userName, email,
					message, serviceContext);

				SessionMessages.add(request, "entryAdded");

				response.sendRedirect(redirectURL);
			}
			catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());
				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter(
		"mvcPath", "/guestbookwebportlet/edit_entry.jsp");
			}
		}
	}
	
	public String getFavoriteColor(Map<String, String> colors) {
		return (String) colors.get(_configuration.favoriteColor());
	}

	@Reference(unbind = "-")
	protected void setEntryService(EntryLocalService entryLocalService) {
		_entryLocalService = entryLocalService;
	}

	@Reference(unbind = "-")
	protected void setGuestbookService(
		GuestbookLocalService guestbookLocalService) {

		_guestbookLocalService = guestbookLocalService;
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		_configuration = ConfigurableUtil.createConfigurable(GuestbookConfiguration.class, properties);
	}

	protected EntryLocalService _entryLocalService;
	protected GuestbookLocalService _guestbookLocalService;
	
	private volatile GuestbookConfiguration _configuration;

	static final Log _log = LogFactoryUtil.getLog(GuestbookPortlet.class);

}