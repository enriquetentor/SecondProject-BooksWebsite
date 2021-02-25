package controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Book;
import servicios.BooksService;

@Controller
@RequestMapping("admin/")
public class AdsAdminController {

	@Autowired
	BooksService booksService;

	@RequestMapping("/listBooks")
	public String listBooks(Model model) {
		model.addAttribute("books", booksService.getAllBooks("",0));
		return "/admin/listarLibros";
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(String id, Model model) {
		booksService.deleteBook(Long.parseLong(id));
		return listBooks(model);
	}

	@RequestMapping("/editBook")
	public String editBook(String id, Model model) {
		Book book = booksService.getBookById(Long.parseLong(id));
		model.addAttribute("book", book);
		return "/admin/editarLibro";
	}

	@RequestMapping("/saveBookChanges")
	public String saveBookChanges(Book book, Model model) {
		booksService.saveBookChanges(book, book.getUser().getId());
		return listBooks(model);
	}
}
