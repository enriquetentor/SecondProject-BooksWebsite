//funciones de validacion
function validarTitulo(title){
	const pattern = /[a-zA-Z0-9?¿ .\u00C0-\u024F\u1E00-\u1EFF]+/;
	var res = pattern.test(title);
	if(!res){
		alert("Error en el título");
	}
	return res;
}

function validarAutor(author){
	const pattern = /[a-zA-Z .\u00C0-\u024F\u1E00-\u1EFF]+/;
	var res = pattern.test(author);
	if(!res){
		alert("Error en el autor");
	}
	return res;
}

function validarPaginas(pages){
	const pattern = /^\d+$/;
	var res = pattern.test(pages);
	if(!res){
		alert("Error en las páginas");
	}
	return res;
}

function validarPecio(price){
	const pattern = /[-]?[0-9]*\.?,?[0-9]+/;
	var res = pattern.test(price);
	if(!res){
		alert("Error en el precio");
	}
	return res;
}
function validarContacto(contact){
	const pattern = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/;
	var res = pattern.test(contact);
	if(!res){
		alert("Error en el contacto");
	}
	return res;
}
function validarEditorial(editorial){
	const pattern= /[a-zA-Z0-9 .\u00C0-\u024F\u1E00-\u1EFF]+/;
	var res = pattern.test(editorial);
	if(!res){
		alert("Error en la editorial");
	}
	return res;
}
function validarISBN(isbn){
	const pattern = /((?:[\dX]{13})|(?:[\d\-X]{17})|(?:[\dX]{10})|(?:[\d\-X]{13}))/;
	var res = pattern.test(isbn);
	if(!res){
		alert("Error en el isbn");
	}
	return res;
}
