package controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import modelo.Book;
import servicios.BooksService;
import utilidadesArchivos.FilesManagement;

@Controller
public class AdsController {

	@Autowired
	private BooksService servicioLibros;

	@RequestMapping("listarAnuncios")
	public String listarAnuncios(Map model, @RequestParam(defaultValue = "") String title, Integer start) {
		int startInt = 0;
		if (start != null) {
			startInt = start.intValue();
		}

		System.out.println("Mostrando resutados: " + startInt);
		
		model.put("books", servicioLibros.getAllBooks(title, startInt));
		model.put("title", title);
		model.put("next", startInt + 5);
		model.put("previous", startInt - 5);
		model.put("total", servicioLibros.getTotalOfBooks(title));
		return "listarLibros";
	}

	@RequestMapping("registrarAnuncio")
	public String registrarAnuncio(Map model) {
		model.put("nuevoLibro", new Book());
		return "registrarAnuncio";
	}

	@RequestMapping("/orderBooksDefault")
	public ResponseEntity<String> orderBooksDefault() {
		String json = new Gson().toJson(servicioLibros.getAllBooksDefault());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/orderBooksNameAZ")
	public ResponseEntity<String> obtenerAnunciosNameAZ() {
		String json = new Gson().toJson(servicioLibros.getAllBooksNameAZ());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/orderBooksNameZA")
	public ResponseEntity<String> obtenerAnunciosNameZA() {
		String json = new Gson().toJson(servicioLibros.getAllBooksNameZA());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/orderBooksAuthorAZ")
	public ResponseEntity<String> obtenerAnunciosAuthorAZ() {
		String json = new Gson().toJson(servicioLibros.getAllBooksAuthorAZ());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/orderBooksAuthorZA")
	public ResponseEntity<String> obtenerAnunciosAuthorZA() {
		String json = new Gson().toJson(servicioLibros.getAllBooksAuthorZA());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/orderBooksPriceAsc")
	public ResponseEntity<String> obtenerAnunciosPrecioAsc() {
		String json = new Gson().toJson(servicioLibros.getAllBooksPriceAsc());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/orderBooksPriceDesc")
	public ResponseEntity<String> obtenerAnunciosPrecioDesc() {
		String json = new Gson().toJson(servicioLibros.getAllBooksPriceDesc());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	/*
	 * @RequestMapping("guardarNuevoAnuncio") public String
	 * guardarNuevoAnuncio(@ModelAttribute("nuevoLibro") @Valid Book newBook,
	 * BindingResult res, Map model, HttpServletRequest request) { if
	 * (res.hasErrors()) { model.put("nuevoLibro", newBook); return
	 * "registrarAnuncio"; } else { long idUser = (long)
	 * request.getAttribute("idUser"); servicioLibros.registerBook(newBook, idUser);
	 * String rutaRealProyecto = request.getServletContext().getRealPath("");
	 * FilesManagement.guardarPortadaLibro(newBook, rutaRealProyecto); return
	 * listarAnuncios(model);// para que despues de registrar liste } }// end
	 * guardarNuevoAnuncio
	 */
}
