package serviciosWEB;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import modelo.Book;
import servicios.BooksService;
import servicios.CategoriesService;
import utilidadesArchivos.FilesManagement;

@Controller
@RequestMapping("servicioWebAnuncios")
public class AdsWebService {

	@Autowired
	private BooksService servicioLibros;

	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping("/registrarAnuncio")
	public ResponseEntity<String> registrarAnuncio(@RequestParam Map<String, Object> formData,
			@RequestParam("portada") CommonsMultipartFile portada, HttpServletRequest request) {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(formData);
		Book libro = gson.fromJson(jsonElement, Book.class);
		libro.setPortada(portada);

		long idUsuario = (long) request.getSession().getAttribute("idUser");

		long categoryId = Long.parseLong(formData.get("categoryId").toString());
		servicioLibros.registerBook(libro, idUsuario, categoryId);

		String rutaRealProyecto = request.getServletContext().getRealPath("");
		FilesManagement.guardarPortadaLibro(libro, rutaRealProyecto);

		for (String nombreCampo : formData.keySet()) {
			System.out.println("he recibido: " + nombreCampo);
		}
		System.out.println("recibido el archivo: " + portada.getName());

		return new ResponseEntity<String>("info recibida OK", HttpStatus.OK);
	}

	@RequestMapping("/obtenerAnuncios")
	public ResponseEntity<String> obtenerAnuncios(HttpServletRequest request) {
		long idUser = (long) request.getSession().getAttribute("idUser");
		String json = new Gson().toJson(servicioLibros.getBooksToList(idUser));
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/borrarAnuncio")
	public ResponseEntity<String> borrarAnuncio(@RequestParam("id") long id) {
		servicioLibros.deleteBook(id);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@RequestMapping("/obtenerAnuncioPorId")
	public ResponseEntity<String> obtenerAnuncioPorId(@RequestParam("id") long idBook) {
		String json = new Gson().toJson(servicioLibros.getBooksToEdit(idBook));
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/guardarCambiosAnuncio")
	public ResponseEntity<String> guardarCambiosAnuncio(@RequestParam("book") String json, HttpServletRequest request) {
		Book book = new Gson().fromJson(json, Book.class);
		long idUser = (long) request.getSession().getAttribute("idUser");
		servicioLibros.saveBookChanges(book, idUser);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@RequestMapping("/obtenerCategorias")
	public ResponseEntity<String> obtenerCategorias() {
		String json = new Gson().toJson(categoriesService.getCategoriesToList());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

}
