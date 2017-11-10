

<%@ include file="/init.jsp" %>

<portlet:renderURL var="htmlFormURL">
	<portlet:param name="mvcRenderCommandName" value="/osgi-tutorial/html-form" />
</portlet:renderURL>

<portlet:renderURL var="lexiconURL">
	<portlet:param name="mvcRenderCommandName" value="/osgi-tutorial/lexicon" />
</portlet:renderURL>

<p>
	<c:if test="${not empty user and not empty user.getFullName()}">
		Hello <b><%= user.getFullName() %></=b> <br> <br>
	</c:if>

		<h2>Learning</h2>
		<ol>
			<li><a href="<%= htmlFormURL %>">HTML Form</a></li>
			<li><a href="<%= lexiconURL %>">Lexicon Styles</a></li>
		</ol>

		<br>

</p>