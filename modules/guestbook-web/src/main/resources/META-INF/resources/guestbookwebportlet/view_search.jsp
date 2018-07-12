<%@ page import="com.liferay.portal.kernel.exception.PortalException" %><%@
page import="com.liferay.portal.kernel.exception.SystemException" %><%@
page import="com.liferay.portal.kernel.log.Log" %><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil" %><%@
page import="com.liferay.portal.kernel.search.Document" %><%@
page import="com.liferay.portal.kernel.search.Field" %><%@
page import="com.liferay.portal.kernel.search.Hits" %><%@
page import="com.liferay.portal.kernel.search.Indexer" %><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.search.SearchContext" %><%@
page import="com.liferay.portal.kernel.search.SearchContextFactory" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.Map" %>

<%@ include file="../init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "keywords");
long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");
%>

<liferay-portlet:renderURL varImpl="searchURL" windowState="maximized">
	<portlet:param name="mvcPath" value="/guestbookwebportlet/view_search.jsp" />
	<portlet:param name="guestbookId" value="<%= String.valueOf(guestbookId) %>" />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewURL" windowState="normal">
	<portlet:param name="mvcPath" value="/guestbookwebportlet/view.jsp" />
	<portlet:param name="guestbookId" value="<%= String.valueOf(guestbookId) %>" />
</portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />

	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%= true %>" label="" name="keywords" size="30"
				title="search-entries" type="text" /> <aui:button type="submit"
				value="search"
			/>
		</span>
	</div>
</aui:form>

<%
	SearchContext searchContext = SearchContextFactory.getInstance(request);

	searchContext.setKeywords(keywords);
	searchContext.setAttribute("paginationType", "more");
	searchContext.setStart(0);
	searchContext.setEnd(10);

	Indexer indexer = IndexerRegistryUtil.getIndexer(Entry.class);

	Hits hits = indexer.search(searchContext);

	List<Entry> entries = new ArrayList<Entry>();

	for (int i = 0; i < hits.getDocs().length; i++) {
			Document doc = hits.doc(i);

			long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

			Entry entry = null;

			try {
					entry = EntryLocalServiceUtil.getEntry(entryId);
			} catch (PortalException pe) {
					_log.error(pe.getLocalizedMessage());
			} catch (SystemException se) {
					_log.error(se.getLocalizedMessage());
			}

			entries.add(entry);
	}

	List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(scopeGroupId);

	Map<String, String> guestbookMap = new HashMap<String, String>();

	for (Guestbook guestbook : guestbooks) {
			guestbookMap.put(Long.toString(guestbook.getGuestbookId()), guestbook.getName());
	}
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found" total="<%= entries.size() %>">
	<liferay-ui:search-container-results results="<%= entries %>" />

	<liferay-ui:search-container-row className="com.nikhilesh.learning.liferay.guestbook.model.Entry" escapedModel="<%= true %>" keyProperty="entryId" modelVar="entry">
		<liferay-ui:search-container-column-text name="guestbook" value="<%= guestbookMap.get(Long.toString(entry.getGuestbookId())) %>" />

		<liferay-ui:search-container-column-text property="message" />

		<liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-jsp align="right" path="/guestbookwebportlet/entry_actions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%!private static Log _log = LogFactoryUtil.getLog("html.guestbookwebportlet.view_search_jsp"); %>