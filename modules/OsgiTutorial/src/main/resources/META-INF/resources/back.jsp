<%@ include file="/init.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<a href="<%= backURL %>">Back</a>
<br><br>