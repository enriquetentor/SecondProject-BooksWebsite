package servicios;

import java.util.List;
import java.util.Map;

import modelo.Book;

//esto es la aproximacion a servicios, es como los DAO y puede confundirse con ello
//generalmente la diferencia es que un servicio puede hacer operaciones de caracter mas amplio y general que un DAO 
public interface BooksService {

	public void registerBook(Book book, long idUser, long idCategory);
	public List<Book> getAllBooks(String title, int start);
	public void deleteBook(long idBook);
	public Book getBookById(long idBook);
	public void saveBookChanges(Book book, long idUser);
	
	public List<Map<String, Object>> getBooksToList(long idUser);
	public Map<String, Object> getBooksToEdit(long idBook);
	
	public int getTotalOfBooks(String title);
	
	public List<Map<String, Object>> getAllBooksDefault();
	public List<Map<String, Object>> getAllBooksNameAZ();
	public List<Map<String, Object>> getAllBooksNameZA();
	public List<Map<String, Object>> getAllBooksAuthorAZ();
	public List<Map<String, Object>> getAllBooksAuthorZA();
	public List<Map<String, Object>> getAllBooksPriceAsc();
	public List<Map<String, Object>> getAllBooksPriceDesc();
	

}
