package com.nikhilesh.learning.liferay.guestbook.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.nikhilesh.learning.liferay.guestbook.model.Guestbook;
import com.nikhilesh.learning.liferay.guestbook.service.GuestbookLocalService;

@Component(
		property = {"model.class.name=com.nikhilesh.learning.liferay.guestbook.model.Guestbook"},
		service = WorkflowHandler.class
		)
public class GuestbookWorkflowHandler extends BaseWorkflowHandler<Guestbook>{

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Guestbook updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long guestbookId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		
		ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");

		return _guestbookLocalService.updateStatus(userId, guestbookId, status, serviceContext);
	}

	@Reference(unbind = "-")
	protected void setGuestbookService(GuestbookLocalService guestbookLocalService) {
		_guestbookLocalService = guestbookLocalService;
	}

	private GuestbookLocalService _guestbookLocalService;

	public static final String CLASS_NAME = Guestbook.class.getName();
	
}
