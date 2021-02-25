<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
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

<springform:form method="post" commandName="category" action="saveNewCategory">

nombre: <springform:input path="name"/> <br/>
descripcion: <springform:input path="description"/> <br/>

<input type="submit" value="REGISTRAR">

</springform:form>

</body>
</html>