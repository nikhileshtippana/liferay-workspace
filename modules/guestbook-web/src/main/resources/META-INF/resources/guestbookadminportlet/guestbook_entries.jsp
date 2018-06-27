<%@ include file="../init.jsp" %>

<liferay-ui:success key="entryDeleted" message="entry-deleted" />

<%
long guestbookId = ParamUtil.getLong(request, "guestbookId");
Guestbook guestbook = GuestbookLocalServiceUtil.getGuestbook(guestbookId);
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/guestbookadminportlet/view.jsp" />
</portlet:renderURL>

<liferay-ui:header backLabel="&laquo; Back" backURL="<%= viewURL %>" title="<%= guestbook.getName() %>" />

<liferay-ui:search-container total="<%= EntryLocalServiceUtil.getEntriesCount(scopeGroupId, guestbookId) %>">
	<liferay-ui:search-container-results results="<%= EntryLocalServiceUtil.getEntries(scopeGroupId, guestbookId, searchContainer.getStart(), searchContainer.getEnd()) %>" />

	<liferay-ui:search-container-row className="com.nikhilesh.learning.liferay.guestbook.model.Entry" modelVar="entry">
		<liferay-ui:search-container-column-text property="message" />
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text name="Author" property="userName" />
		<liferay-ui:search-container-column-text name="Create Date" value="<%= sdf.format(entry.getCreateDate()) %>" />
		<liferay-ui:search-container-column-text name="Modified Date" value="<%= sdf.format(entry.getModifiedDate()) %>" />

		<liferay-ui:search-container-column-text name="status">
			<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>" status="<%= entry.getStatus() %>" />
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-jsp align="right" path="/guestbookadminportlet/entry_actions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>