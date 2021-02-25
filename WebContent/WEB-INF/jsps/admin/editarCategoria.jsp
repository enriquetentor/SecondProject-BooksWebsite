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

Actualiza los datos de la categoria<br>

<springform:form method="post" commandName="category" action="saveCategoryChanges">

Nombre: <springform:input  path="name" /><br/>
Descripción: <springform:input  path="description"/><br/>

<springform:hidden path="id"/>

<input type="submit" value="Guardar cambios">

</springform:form>

</body>
</html>