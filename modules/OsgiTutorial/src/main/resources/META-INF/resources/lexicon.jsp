<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>

<%@ include file="/back.jsp" %>

<portlet:actionURL name="/osgi-tutorial/lexicon/add-user" var="addUserURL" />
<portlet:actionURL name="/osgi-tutorial/lexicon/add-group" var="addGroupURL" />

<h2>Lexicon Styles</h2>

<liferay-ui:success key="addUserSuccess" message="User has been added successfully" />
<liferay-ui:success key="addGroupSuccess" message="Group has been added successfully" />

<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-user") %>' url="<%= addUserURL.toString() %>" />
	<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-group") %>' url="<%= addGroupURL.toString() %>" />
</liferay-frontend:add-menu>

1. <b>liferay-frontend:add-menu</b> - look to the bottom right.