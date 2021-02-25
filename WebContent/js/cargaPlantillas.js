function cargarPlantillaListarLibros(){
	var res = "";
	$.ajax({
		url : "plantillas-mustache/listarLibros.html",
		async: false,//con async a false hasta que no acabe ajax js no sigue
		success: function(data){
			res = data;
		}	
	});
	return res;
}

function cargarPlantillaListarLibros2(){
	var res = "";
	$.ajax({
		url : "plantillas-mustache/listarLibros2.html",
		async: false,//con async a false hasta que no acabe ajax js no sigue
		success: function(data){
			res = data;
		}	
	});
	return res;
}

function cargarPlantillaRegistrarLibro(){
	var res = "";
	$.ajax({
		url : "plantillas-mustache/registrarLibro.html",
		async: false,
		success: function(data){
			res = data;
		}	
	});
	return res;
}

function cargarPlantillaEditarLibro(){
	var res = "";
	$.ajax({
		url : "plantillas-mustache/editarLibro.html",
		async: false,
		success: function(data){
			res = data;
		}	
	});
	return res;
}
