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
	
<!-- 	Mediante estas utilidades podemos acceder al valor de las variables -->
<!-- 	del Principal proveidas por S Security -->
	
	<security:authentication property="principal.username" />
	<security:authentication property="principal.password" />
	</hr>



	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout"></input>

	</form:form>



</body>
</html>