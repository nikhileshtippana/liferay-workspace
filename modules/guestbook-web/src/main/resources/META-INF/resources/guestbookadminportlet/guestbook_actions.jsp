<%@ include file="../init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request
				.getAttribute("SEARCH_CONTAINER_RESULT_ROW");

Guestbook guestbook = (Guestbook)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= EntryLocalServiceUtil.getEntriesCount(scopeGroupId, guestbook.getGuestbookId()) > 0 %>">
		<portlet:renderURL var="showEntriesURL">
			<portlet:param name="mvcPath" value="/guestbookadminportlet/guestbook_entries.jsp" />
			<portlet:param name="guestbookId" value="<%= String.valueOf(guestbook.getGuestbookId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="all_pages" message="Show Entries" url="<%= showEntriesURL %>" />
	</c:if>

	<portlet:renderURL var="editURL">
		<portlet:param name="guestbookId" value="<%= String.valueOf(guestbook.getGuestbookId()) %>" />
		<portlet:param name="mvcPath" value="/guestbookadminportlet/edit_guestbook.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />

	<liferay-security:permissionsURL
		modelResource="<%= Guestbook.class.getName() %>"
		modelResourceDescription="<%= guestbook.getName() %>"
		resourcePrimKey="<%= String.valueOf(guestbook.getGuestbookId()) %>"
		var="permissionsURL"
	/>

	<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	<portlet:actionURL name="deleteGuestbook" var="deleteURL">
		<portlet:param name="guestbookId" value="<%= String.valueOf(guestbook.getGuestbookId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>