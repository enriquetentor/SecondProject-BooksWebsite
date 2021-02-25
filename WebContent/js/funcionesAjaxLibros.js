function borrarLibro(elementoClick){
	var aceptar = confirm("borrar anuncio");

	if(aceptar){
		alert("hiciste click sobre el elemento de id: " + elementoClick.attr("idp"));

		$.ajax("servicioWebAnuncios/borrarAnuncio?id=" + elementoClick.attr("idp"),{
			type : "DELETE" ,
			success : function(){
				alert("anuncio borrado correctamente");
				mostrarLibros();
			}
		});//end ajax
	}//end if
}

function editarLibro(idEditar){
	$.ajax("servicioWebAnuncios/obtenerAnuncioPorId?id=" + idEditar,{
		success : function(respuesta){
			alert("recibido del server: " + respuesta);
			
			$("#contenedor").html(plantillaEditarLibro);
			var libro = JSON.parse(respuesta);
			$("#title").val(libro.title);
			$("#author").val(libro.author);
			$("#pages").val(libro.pages);
			$("#price").val(libro.price);
			$("#contact").val(libro.contact);
			$("#editorial").val(libro.editorial);
			$("#isbn").val(libro.isbn);
	
			$("#formularioEditarLibro").submit(function(e){
				alert("recoger informacion y mandarlo al servlet para la id: " + idEditar);
				var title = $("#title").val();
				var author = $("#author").val();
				var pages = $("#pages").val();
				var price = $("#price").val();
				var contact = $("#contact").val();
				var editorial = $("#editorial").val();
				var isbn = $("#isbn").val();
				var bookId = idEditar;
				if(validarTitulo(title) && validarAutor(author) && validarPaginas(pages) && validarPecio(price) && validarContacto(contact)
						&& validarEditorial(editorial) && validarISBN(isbn)){
					var libro = {title: title, author: author, pages: pages, price: price, contact: contact, 
							editorial: editorial, isbn: isbn, id: bookId};
					var json = JSON.stringify(libro);
					alert("json a mandar al server: " + json);
	
					$.ajax("servicioWebAnuncios/guardarCambiosAnuncio",
						{
							type : "POST" ,
							data : "book=" + json ,
							success : function(){
								alert("libro actualizado en el servicio correctamente");
							}
						}
					);
				}//end if
				e.preventDefault();
			});
		}
	});//end ajax
}

function mostrarLibros() {
	$.ajax("servicioWebAnuncios/obtenerAnuncios", {
		success : function(data) {
			var libros = JSON.parse(data);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#contenedor").html(contenido);
			
			$(".enlaceBorrar").click(function(){
				borrarLibro($(this))
			});//end click enlaceBorrar

			$(".enlaceEditar").click(function(){
				var idEditar = $(this).attr("idp");
				editarLibro(idEditar);
			});//end click enlaceEditar
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

function registrarLibros(){
	$.ajax("servicioWebAnuncios/obtenerCategorias", {
		success : function(res){
			var categorias = JSON.parse(res);
			var contenido = Mustache.render(plantillaRegistrarLibros,categorias);
			$("#contenedor").html(contenido);
			
			$("form").submit(function(e){
				alert("js a ejecutar antes de enviar form");
				//vamos a recoger los datos del formulario
				var title = $("#title").val();
				var author = $("#author").val();
				var pages = $("#pages").val();
				var price = $("#price").val();
				var contact = $("#contact").val();
				var editorial = $("#editorial").val();
				var isbn = $("#isbn").val();
				if(validarTitulo(title) && validarAutor(author) && validarPaginas(pages) && validarPecio(price) && validarContacto(contact)
						&& validarEditorial(editorial) && validarISBN(isbn)){
					//todo esta correcto y lo voy a mandar al servicio del servidor para que lo registre
					var libro = {title: title, author: author, pages: pages, price: price, contact: contact, 
							editorial: editorial, isbn: isbn};
					var json = JSON.stringify(libro);
					
					alert("Vamos a mandar al server: " + json);
					
					var form = document.forms[1];
					var formData = new FormData(form);
					$.ajax("servicioWebAnuncios/registrarAnuncio",{
							type : "POST" ,
							data : formData ,
							cache: false ,
							contentType: false ,
							processData: false ,
							success : function(res){
								alert("respuesta del servicio: " + res);
							}
						}
					);//end ajax
				}//end if
				//con esto evitamos que el form se envie, es lo mas normal cuando queremos procesar el form por js
				e.preventDefault();
			});
		}
	})
}//end registroLibros()

function mostrarLibrosDefault() {
	$.ajax("orderBooksDefault", {
		success : function(json) {
			var libros = JSON.parse(json);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#booksContainer").html(contenido);
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

function mostrarLibrosNameAZ() {
	$.ajax("orderBooksNameAZ", {
		success : function(json) {
			var libros = JSON.parse(json);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#booksContainer").html(contenido);
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

function mostrarLibrosNameZA() {
	$.ajax("orderBooksNameZA", {
		success : function(json) {
			var libros = JSON.parse(json);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#booksContainer").html(contenido);
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

function mostrarLibrosAuthorAZ() {
	$.ajax("orderBooksAuthorAZ", {
		success : function(json) {
			var libros = JSON.parse(json);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#booksContainer").html(contenido);
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

function mostrarLibrosAuthorZA() {
	$.ajax("orderBooksAuthorZA", {
		success : function(json) {
			var libros = JSON.parse(json);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#booksContainer").html(contenido);
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

function mostrarLibrosPriceAsc() {
	$.ajax("orderBooksPriceAsc", {
		success : function(json) {
			var libros = JSON.parse(json);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#booksContainer").html(contenido);
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

function mostrarLibrosPriceDesc() {
	$.ajax("orderBooksPriceDesc", {
		success : function(json) {
			var libros = JSON.parse(json);
			var contenido = "";

			contenido = Mustache.render(plantillaListarLibros, libros);

			$("#booksContainer").html(contenido);
		}//end success
	}//end objeto
	);//end $.ajax
}//end mostrarLibros()

