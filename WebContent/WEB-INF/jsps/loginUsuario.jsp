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
		<div style="color: red">${mensaje}</div>
	
		Introduce tus datos para entrar:
		<form method="POST" action="loginUsuario">
			Nombre: <input type="text" name="name"><br> 
			Contraseña: <input type="password" name="password"><br> 
			
			<input type="submit" value="ENTRAR">
		</form>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>