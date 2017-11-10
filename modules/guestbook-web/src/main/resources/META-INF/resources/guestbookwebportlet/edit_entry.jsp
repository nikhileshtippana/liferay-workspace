<%@ include file="../init.jsp" %>

<%
long entryId = ParamUtil.getLong(renderRequest, "entryId");

Entry entry = null;

if (entryId > 0) {
	entry = EntryLocalServiceUtil.getEntry(entryId);
}

long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/guestbookwebportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="saveEntry" var="saveEntryURL" />

<aui:form action="<%= saveEntryURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= entry %>" model="<%= Entry.class %>" />

	<aui:fieldset>
		<aui:input name="name" />
		<aui:input name="email" />
		<aui:input name="message" />
		<aui:input name="entryId" type="hidden" />
		<aui:input name="guestbookId" type="hidden" value="<%= entry == null ? guestbookId : entry.getGuestbookId() %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button onClick="<%= viewURL %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>