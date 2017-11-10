<%@ page import="com.liferay.portal.kernel.model.Country" %><%@
page import="com.liferay.portal.kernel.service.CountryServiceUtil" %>

<%@ page import="java.util.List" %>

<%@ include file="/back.jsp" %>

<!-- <portlet:actionURL name="processHtmlForm" var="myActionURL">
	<portlet:param name="page" value="htmlForm" />
</portlet:actionURL> -->

<%
List<Country> countries = CountryServiceUtil.getCountries();
%>

<aui:form action="<%= myActionURL %>" method="post" name="myForm">
	<aui:input label="My Text Input" name="myTextInput" type="text" value='<%= "My Text Value" %>' />

	<aui:select label="Select Country" name="country">
		<c:forEach items="<%= countries %>" var="item">
			<aui:option value="${item.number }"><liferay-ui:message key="${item.name }"/></aui:option>
		</c:forEach>
	</aui:select>
	<!-- <aui:button type="submit" /> -->
</aui:form>