<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="cssExterno/bootstrap.css">
</head>
<body>

<jsp:include page="../menu.jsp"></jsp:include>

	<div id="pagina" class="marginPercent">
		<div class="marginLR7">
			<a href="#" id="enlaceListado" >ver mis anuncios</a><br>
			<a href="#" id="enlaceRegistro">registrar un nuevo anuncio</a>
		</div>
		<hr>
		<div id="contenedor"></div>
	</div><!-- end pagina -->

<jsp:include page="../footer.jsp"></jsp:include>

	<script type="text/javascript" src="jsExterno/jquery.js" ></script>
	<script type="text/javascript" src="jsExterno/mustache.js"></script>
	<script type="text/javascript" src="js/cargaPlantillas.js"></script>
	<script type="text/javascript" src="js/funcionesAjaxLibros.js"></script>
	<script type="text/javascript" src="js/validaciones.js"></script>
	<script type="text/javascript">
		var plantillaListarLibros = cargarPlantillaListarLibros();
		var plantillaRegistrarLibros = cargarPlantillaRegistrarLibro();
		var plantillaEditarLibro = cargarPlantillaEditarLibro();
		
		//programacion de eventos del menu
		$("#enlaceListado").click(function(){
			mostrarLibros();
		});

		$("#enlaceRegistro").click(function(){
			registrarLibros();
		});
		
	</script>
</body>
</html>