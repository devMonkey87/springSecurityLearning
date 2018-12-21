<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Bienvenides</title>

</head>
<body>


	<h1>BIENVENIDOS</h1>

	<hr>
	<security:authentication property="principal.username" />
	</hr>



	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout"></input>

	</form:form>



</body>
</html>