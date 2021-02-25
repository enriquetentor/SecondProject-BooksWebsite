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
<c:forEach var="book" items="${books}">
	<div style="margin: 10px">
		usuario <b>${book.user.name}</b> <br/>
		titulo: ${book.title} <br/>
		<img src="subidas/${book.id}.jpg" style="height: 80px"/> <br/>
		precio: ${book.price} <br/>
		email: ${book.contact} <br/>
		<a onclick="return confirm('¿Estás seguro?')" href="deleteBook?id=${book.id}">Borrar</a>
		<a href="editBook?id=${book.id}">Editar</a>
	</div>
	<hr>
</c:forEach>

</body>
</html>