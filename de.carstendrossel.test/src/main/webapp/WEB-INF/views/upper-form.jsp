<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Upper Form</title>
    </head>
    <body>
        <h1>Upper Form</h1>
        <form:form id="form" method="post" modelAttribute="upperFormBean" >
        	<fieldset>
		  		<form:label path="text">
		  			Text <form:errors path="text" cssClass="error" />
		 		</form:label>
		  		<form:input path="text" />
				<p><button type="submit">Submit</button></p>
				<p><form:input path="upperText" readonly="true"/></p>
		  	</fieldset>
        </form:form>
    </body>
</html>