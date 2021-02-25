<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-primary">
  <a class="navbar-brand" href="listarAnuncios">NICEBOOKS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="misanuncios">Mis anuncios</a>
      </li>
      <c:if test="${sessionScope.idUser==null}">
	      <li class="nav-item">
	        <a class="nav-link" href="prepararIdentificacionUsuario">Identificarme</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="prepararRegistroUsuario">Registrarme</a>
	      </li>
	  </c:if>
	  <c:if test="${sessionScope.idUser!=null}">
	 	  <li class="nav-item">
	        <a class="nav-link" href="cerrarSesionUsuario">Cerrar Sesion</a>
	      </li>
	  </c:if>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Buscar">
      <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Buscar</button>
    </form>
  </div>
</nav>
