<%@ include file="../init.jsp" %>

<liferay-ui:success key="guestbookAdded" message="guestbook-added" />
<liferay-ui:success key="guestbookUpdated" message="guestbook-updated" />
<liferay-ui:success key="guestbookDeleted" message="guestbook-deleted" />

<%
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
%>

<liferay-ui:search-container total="<%= GuestbookLocalServiceUtil.getGuestbooksCount(scopeGroupId) %>">
	<liferay-ui:search-container-results results="<%= GuestbookLocalServiceUtil.getGuestbooks(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>" />

	<liferay-ui:search-container-row className="com.nikhilesh.learning.liferay.guestbook.model.Guestbook" modelVar="guestbook">
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text name="Author" property="userName" />
		<liferay-ui:search-container-column-text name="Create Date" value="<%= sdf.format(guestbook.getCreateDate()) %>" />
		<liferay-ui:search-container-column-text name="Modified Date" value="<%= sdf.format(guestbook.getModifiedDate()) %>" />

		<liferay-ui:search-container-column-text name="status">
			<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>" status="<%= guestbook.getStatus() %>" />
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-jsp align="right" path="/guestbookadminportlet/guestbook_actions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button-row cssClass="guestbook-admin-buttons">
	<portlet:renderURL var="addGuestbookURL">
		<portlet:param name="mvcPath" value="/guestbookadminportlet/edit_guestbook.jsp" />
		<portlet:param name="redirect" value='<%= "currentURL" %>' />
	</portlet:renderURL>

	<aui:button onClick="<%= addGuestbookURL %>" value="Add Guestbook" />
</aui:button-row>