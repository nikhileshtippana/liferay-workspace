package com.nikhilesh.learning.liferay.guestbook.web.portlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.nikhilesh.learning.liferay.guestbook.model.Entry;
import com.nikhilesh.learning.liferay.guestbook.model.Guestbook;
import com.nikhilesh.learning.liferay.guestbook.service.EntryLocalService;
import com.nikhilesh.learning.liferay.guestbook.service.GuestbookLocalService;
import com.nikhilesh.learning.liferay.guestbook.web.constants.GuestbookPortletKeys;

@Component(
		immediate = true, property = {
				"com.liferay.portlet.add-default-resource=true",
				"com.liferay.portlet.display-category=category.hidden",
				"com.liferay.portlet.scopeable=true",
		        "com.liferay.portlet.header-portlet-css=/css/admin/main.css",
				"javax.portlet.display-name=Guestbooks",
				"javax.portlet.expiration-cache=0",
				"javax.portlet.init-param.portlet-title-based-navigation=true",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/guestbookadminportlet/view.jsp",
				"javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK_ADMIN,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=administrator",
				"javax.portlet.supports.mime-type=text/html"
		},
		service = Portlet.class
)
public class GuestbookAdminPortlet extends MVCPortlet {

	public void addGuestbook(ActionRequest request, ActionResponse response)
		throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Guestbook.class.getName(), request);

		String name = ParamUtil.getString(request, "name");

		try {
			_guestbookLocalService.addGuestbook(
				serviceContext.getUserId(), name, serviceContext);
			SessionMessages.add(request, "guestbookAdded");
		}
		catch (PortalException pe) {
			Logger.getLogger(
				GuestbookAdminPortlet.class.getName()).log(Level.SEVERE, null,
				pe);
			SessionErrors.add(request, pe.getClass().getName());
			response.setRenderParameter(
				"mvcPath", "/guestbookadminportlet/edit_guestbook.jsp");
		}
	}

	public void deleteGuestbook(ActionRequest request, ActionResponse response)
		throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Guestbook.class.getName(), request);

		long guestbookId = ParamUtil.getLong(request, "guestbookId");

		try {
			_guestbookLocalService.deleteGuestbook(guestbookId, serviceContext);
			SessionMessages.add(request, "guestbookDeleted");
		}
		catch (PortalException pe) {
			Logger.getLogger(
				GuestbookAdminPortlet.class.getName()).log(Level.SEVERE, null,
				pe);
			SessionErrors.add(request, pe.getClass().getName());
		}
	}

	public void updateGuestbook(ActionRequest request, ActionResponse response)
		throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Guestbook.class.getName(), request);

		String name = ParamUtil.getString(request, "name");
		long guestbookId = ParamUtil.getLong(request, "guestbookId");

		try {
			_guestbookLocalService.updateGuestbook(
				serviceContext.getUserId(), guestbookId, name, serviceContext);
			SessionMessages.add(request, "guestbookUpdated");
		} catch (PortalException pe) {
			Logger.getLogger(
				GuestbookAdminPortlet.class.getName()).log(Level.SEVERE, null,
				pe);
			SessionErrors.add(request, pe.getClass().getName());
			response.setRenderParameter(
				"mvcPath", "/guestbookadminportlet/edit_guestbook.jsp");
		}
	}

	public void deleteEntry(ActionRequest request, ActionResponse response)
			throws PortalException {

		long entryId = ParamUtil.getLong(request, "entryId");
		long guestbookId = ParamUtil.getLong(request, "guestbookId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Entry.class.getName(), request);

		try {
			response.setRenderParameter("guestbookId", Long.toString(guestbookId));

			_entryLocalService.deleteEntry(entryId, serviceContext);
			SessionMessages.add(request, "entryDeleted");
			response.setRenderParameter("mvcPath", "/guestbookadminportlet/guestbook_entries.jsp");
		}
		catch (Exception e) {
			Logger.getLogger(
					Guestbook.class.getName()).log(Level.SEVERE, null, e);
			SessionErrors.add(request, e.getClass().getName());
		}
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

	protected EntryLocalService _entryLocalService;
	protected GuestbookLocalService _guestbookLocalService;

}