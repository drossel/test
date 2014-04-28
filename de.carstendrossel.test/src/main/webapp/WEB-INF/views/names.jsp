<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Names</title>
	</head>
	<body>
		<h1>Names</h1>
		<c:forEach var="name" items="${names}">
			<p><c:out value="${name}"/> </p>
		</c:forEach>
		<form:form id="form" method="post" modelAttribute="nameBean">
		  	<form:label path="newName">
		  		New Name <form:errors path="newName"/>
		 	</form:label>
		  	<form:input path="newName" />
			<p><button type="submit">Add Name</button></p>
		</form:form>
	</body>
</html>