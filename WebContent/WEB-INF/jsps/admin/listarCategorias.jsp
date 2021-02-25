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
<a href="registerCategory">Registrar</a>

<hr>
<c:forEach var="categories" items="${categories}">
	<div style="margin: 10px">
		id: ${categories.id} <br/>
		nombre: ${categories.name} <br/>
		descripcion: ${categories.description} <br/>
		<a onclick="return confirm('¿Estás seguro?')" href="deleteCategory?id=${categories.id}">Borrar</a>
		<a href="editCategory?id=${categories.id}">Editar</a>
	</div>
	<hr>
</c:forEach>

</body>
</html>