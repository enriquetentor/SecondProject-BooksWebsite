<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="marginLR7"><h2>BIENVENIDO AL PORTAL DE LIBROS</h2></div>
	
	<hr>
	<form action="listarAnuncios" class="marginLR7">
		Titulo: <input type="text" name="title" value="${title}"/>
		<input type="submit" value="Buscar"/>
	</form>
	<hr>
	
	<div class="marginLR7">
		<c:if test="${previous >= 0}">
			<a class="btn btn-primary" href="listarAnuncios?start=${previous}&title=${title}">Anterior</a>
		</c:if>
		<c:if test="${previous < 0}">
			<a class="btn btn-primary disabled" href="listarAnuncios?start=${previous}&title=${title}">Anterior</a>
		</c:if>
		
		<c:if test="${next < total}">
			<a class="btn btn-primary" href="listarAnuncios?start=${next}&title=${title}">Siguiente</a>
		</c:if>
		<c:if test="${next >= total}">
			<a class="btn btn-primary disabled" href="listarAnuncios?start=${next}&title=${title}">Siguiente</a>
		</c:if>
	</div>
	<c:if test="${next < total}">
		<div class="marginLR7">(${previous+6}-${next} de ${total})</div>
	</c:if>
	<c:if test="${next >= total && previous+6 != total && total!=0}">
		<div class="marginLR7">(${previous+6}-${total} de ${total})</div>
	</c:if>
	<c:if test="${previous+6 == total || total==0}">
		<div class="marginLR7">(${total} de ${total})</div>
	</c:if>
	<hr>
	
	<div class="btn-group marginLR7" id="orderBooksDiv">
	  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ordenar por: </button>
	  <!-- <span class="dropdown-item-text">M&aacute;s relevantes</span> -->
	  <div class="dropdown-menu" id="orderBooks">
	  	<a class="dropdown-item currentOrderBooks" href="#" id="orderBooksDefault">M&aacute;s recientes</a>
	    <a class="dropdown-item" href="#" id="orderBooksNameAZ">Nombre (A-Z)</a>
	    <a class="dropdown-item" href="#" id="orderBooksNameZA">Nombre (Z-A)</a> 
	    <a class="dropdown-item" href="#" id="orderBooksAutorAZ">Autor (A-Z)</a>
	    <a class="dropdown-item" href="#" id="orderBooksAutorZA">Autor (Z-A)</a>
	    <a class="dropdown-item" href="#" id="orderBooksPriceAsc">Precio (m&aacute;s baratos primero)</a>
	    <a class="dropdown-item" href="#" id="orderBooksPriceDesc">Precio (m&aacute;s caros primero)</a>
	    <!-- <div class="dropdown-divider"></div>
	    <a class="dropdown-item" href="#">Separated link</a> -->
	  </div>
	</div>
	<hr>
</div>

<div id="booksContainer">
<div class="card-group marginPercent row row-cols-1 row-cols-xl-5 row-cols-xxl-6 row-cols-2 row-cols-md-3 row-cols-sm-3 row-cols-lg-4 marginLR7">
  
  <c:forEach var="book" items="${books}" >
  <div class="col mb-4">
    <div class="card h-100">
      <img src="subidas/${book.id}.jpg" class="imagenCarta card-img-top" alt="${book.title}-${book.author}">
      <div class="card-body">
        <h5 class="card-title">${book.title}-${book.author}</h5>
        <!--<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>  -->
      </div>
      <ul class="list-group list-group-flush">
	    <li class="list-group-item">${book.price}&#8364</li>
	  </ul>
	 <div class="card-footer cfCustom">
	 	<div class="center detailsCF">
	   	<a href="#data" class="btn btn-outline-info" data-toggle="modal">Detalles</a>
	   	</div>
	  </div>
    </div>
  </div>
  </c:forEach>
  
</div>
</div>

<!--<div class="modal" id="data" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
	<div class="modal-content">
	  <div class="modal-header">
		<h2 class="modal-title">Libro</h2>
		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		  <span aria-hidden="true">&times;</span>
		</button>
	  </div>
	  <div class="modal-body">
			<nav>
			  <div class="nav nav-tabs" id="nav-tab" role="tablist">
				<a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Descripcion</a>
				<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Detalles</a>
			  </div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
			  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
				<p>Paginas-Editorial-ISBN</p>
			  </div>
			  <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
				<p>Contacto</p>
			  </div>
			</div>
	  </div>
	</div>
  </div>
</div>-->

<jsp:include page="footer.jsp"></jsp:include>

	<script type="text/javascript" src="jsExterno/jquery.js" ></script>
	<script type="text/javascript" src="jsExterno/mustache.js"></script>
	<script type="text/javascript" src="js/cargaPlantillas.js"></script>
	<script type="text/javascript" src="js/funcionesAjaxLibros.js"></script>
	<script type="text/javascript" src="js/validaciones.js"></script>
	<script type="text/javascript">
		var plantillaListarLibros = cargarPlantillaListarLibros2();
		
		//programacion de eventos del menu
		$("#orderBooksDefault").click(function(){
			$("#orderBooks > a").removeClass("currentOrderBooks");
		    $(this).addClass("currentOrderBooks");
		    mostrarLibrosDefault();
		});
		
		$("#orderBooksNameAZ").click(function(title, start){
			$("#orderBooks > a").removeClass("currentOrderBooks");
		    $(this).addClass("currentOrderBooks");
		    mostrarLibrosNameAZ(title, start);
		});
		
		$("#orderBooksNameZA").click(function(){
			$("#orderBooks > a").removeClass("currentOrderBooks");
		    $(this).addClass("currentOrderBooks");
		    mostrarLibrosNameZA();
		});
		
		$("#orderBooksAutorAZ").click(function(){
			$("#orderBooks > a").removeClass("currentOrderBooks");
		    $(this).addClass("currentOrderBooks");
		    mostrarLibrosAuthorAZ();
		});
		
		$("#orderBooksAutorZA").click(function(){
			$("#orderBooks > a").removeClass("currentOrderBooks");
		    $(this).addClass("currentOrderBooks");
		    mostrarLibrosAuthorZA();
		});
		
		$("#orderBooksPriceAsc").click(function(){
			$("#orderBooks > a").removeClass("currentOrderBooks");
		    $(this).addClass("currentOrderBooks");
		    mostrarLibrosPriceAsc();
		});
		
		$("#orderBooksPriceDesc").click(function(){
			$("#orderBooks > a").removeClass("currentOrderBooks");
		    $(this).addClass("currentOrderBooks");
		    mostrarLibrosPriceDesc();
		});
		
	</script>

</body>
</html>