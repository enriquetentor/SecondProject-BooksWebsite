package constantesSQL;

public class SQLConstants {
	public static final String GET_BOOKS_TO_LIST = "SELECT * FROM libros WHERE user_id=:idUser ORDER BY id DESC";
	public static final String GET_BOOK_TO_EDIT = "SELECT * FROM libros WHERE id=:idBook";
	public static final String GET_CATEGORIES_TO_LIST = "SELECT * FROM categorias";
	
	public static final String GET_BOOKS_ORDER_BY_ID_DESC = "SELECT id,title,author,price FROM libros ORDER BY id DESC LIMIT 5";
	public static final String GET_BOOKS_ORDER_BY_NAME_AZ = "SELECT id,title,author,price FROM libros ORDER BY title, author, price LIMIT 5";
	public static final String GET_BOOKS_ORDER_BY_NAME_ZA = "SELECT id,title,author,price FROM libros ORDER BY title DESC, author, price LIMIT 5";
	public static final String GET_BOOKS_ORDER_BY_AUTHOR_AZ = "SELECT id,title,author,price FROM libros ORDER BY author, title, price LIMIT 5";
	public static final String GET_BOOKS_ORDER_BY_AUTHOR_ZA = "SELECT id,title,author,price FROM libros ORDER BY author DESC, title, price LIMIT 5";
	public static final String GET_BOOKS_ORDER_BY_PRICE_ASC = "SELECT id,title,author,price FROM libros ORDER BY price, title, author LIMIT 5";
	public static final String GET_BOOKS_ORDER_BY_PRICE_DESC = "SELECT id,title,author,price FROM libros ORDER BY price DESC, title, author LIMIT 5";
	
	public static final String GET_TOTAL_OF_BOOKS = "SELECT COUNT(id) FROM libros WHERE title like :title";
}