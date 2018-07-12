<%@ include file="../init.jsp" %>

<%
long entryId = ParamUtil.getLong(renderRequest, "entryId");

Entry entry = null;

if (entryId > 0) {
	entry = EntryLocalServiceUtil.getEntry(entryId);
}

long guestbookId = entry == null ? ParamUtil.getLong(renderRequest, "guestbookId") : entry.getGuestbookId();
%>

<portlet:renderURL var="viewURL" windowState="normal">
	<portlet:param name="mvcPath" value="/guestbookwebportlet/view.jsp" />
	<portlet:param name="guestbookId" value="<%= String.valueOf(guestbookId) %>" />
</portlet:renderURL>

<portlet:actionURL name="saveEntry" var="saveEntryURL">
	<portlet:param name="redirect" value="<%= viewURL %>"/>
</portlet:actionURL>

<aui:form action="<%= saveEntryURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= entry %>" model="<%= Entry.class %>" />

	<aui:fieldset>
		<aui:input name="name" />
		<aui:input name="email" />
		<aui:input name="message" />
		<aui:input name="entryId" type="hidden" />
		<aui:input name="guestbookId" type="hidden" value="<%= guestbookId %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button onClick="<%= viewURL %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>