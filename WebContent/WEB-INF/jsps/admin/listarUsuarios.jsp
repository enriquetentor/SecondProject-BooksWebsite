<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<hr>
<a href="registerUser">Registrar</a>

<hr>
<c:forEach var="users" items="${users}">
	<div style="margin: 10px">
		id: ${users.id} <br/>
		nombre: ${users.name} <br/>
		password: ${users.password} <br/>
		<a onclick="return confirm('¿Estás seguro?')" href="deleteUser?id=${users.id}">Borrar</a>
		<a href="editUser?id=${users.id}">Editar</a>
	</div>
	<hr>
</c:forEach>

</body>
</html>