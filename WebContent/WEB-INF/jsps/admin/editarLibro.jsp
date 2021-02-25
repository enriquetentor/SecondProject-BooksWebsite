<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

Actualiza los datos del anuncio<br>

<springform:form method="post" commandName="book" action="saveBookChanges">

Titulo: <springform:input  path="title" /><br/>
Autor: <springform:input  path="author"/><br/>
Páginas: <springform:input  path="pages"/><br/>
Precio: <springform:input  path="price"/><br/>
Contacto: <springform:input  path="contact"/><br/>
Editorial: <springform:input path="editorial"/><br/>
ISBN: <springform:input  path="isbn"/><br/>

<springform:hidden path="id"/>
<springform:hidden path="user.id"/>

<input type="submit" value="Guardar cambios">

</springform:form>

</body>
</html>