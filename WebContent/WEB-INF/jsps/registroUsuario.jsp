<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="cssExterno/bootstrap.css">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<div class="marginPercent">
	<springform:form method="post" commandName="nuevoUsuario" 
	action="guardarNuevoUsuario">
	
	Nombre: <springform:input path="name"/> <br/>
	Contraseña: <springform:input type="password" path="password"/> <br/>
	
	<input type="submit" value="REGISTRARME">
	
	</springform:form>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>