<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="color: red">${mensaje}</div>
<div class="marginPercent">
	Introduce tu contrase�a de admin:<br>
	<form action="loginAdmin" method="post">
	contrase�a: <input type="password" name="pass"><br>
	<input type="submit" value="ENTRAR">
	</form>
</div>
</body>
</html>