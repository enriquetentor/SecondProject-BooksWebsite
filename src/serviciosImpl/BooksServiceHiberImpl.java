package serviciosImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.SQLConstants;
import modelo.Book;
import modelo.Categories;
import modelo.User;
import servicios.BooksService;

@Service
@Transactional
public class BooksServiceHiberImpl implements BooksService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int getTotalOfBooks(String title) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_TOTAL_OF_BOOKS);
		query.setParameter("title", "%" + title + "%");
		return Integer.parseInt(query.list().get(0).toString());
	}

	@Override
	public void registerBook(Book book, long idUser, long categoryId) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, idUser);
		book.setUser(user);
		Categories category = (Categories) sessionFactory.getCurrentSession().get(Categories.class, categoryId);
		book.getCategories().add(category);
		sessionFactory.getCurrentSession().save(book);
	}

	@Override
	public List<Book> getAllBooks(String title, int start) {
		return sessionFactory.getCurrentSession().createCriteria(Book.class)
				.add(Restrictions.like("title", "%" + title + "%"))
				.setFirstResult(start)
				.setMaxResults(5)
				.addOrder(Order.desc("id")).list();
	}

	@Override
	public List<Map<String, Object>> getBooksToList(long idUser) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_TO_LIST);
		query.setParameter("idUser", idUser);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public void deleteBook(long idBook) {
		Book libroDelete = (Book) sessionFactory.getCurrentSession().get(Book.class, idBook);
		sessionFactory.getCurrentSession().delete(libroDelete);
	}

	@Override
	public Book getBookById(long idBook) {
		Book libro = (Book) sessionFactory.getCurrentSession().get(Book.class, idBook);
		return libro;
	}

	@Override
	public void saveBookChanges(Book book, long idUser) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, idUser);
		if (user == null) {
			return;
		}
		book.setUser(user);
		sessionFactory.getCurrentSession().merge(book);
	}

	@Override
	public Map<String, Object> getBooksToEdit(long idBook) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOK_TO_EDIT);
		query.setParameter("idBook", idBook);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		Map<String, Object> res = (Map<String, Object>) query.uniqueResult();
		return res;
	}

	@Override
	public List<Map<String, Object>> getAllBooksDefault() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_ORDER_BY_ID_DESC);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public List<Map<String, Object>> getAllBooksNameAZ() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_ORDER_BY_NAME_AZ);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public List<Map<String, Object>> getAllBooksNameZA() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_ORDER_BY_NAME_ZA);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public List<Map<String, Object>> getAllBooksAuthorAZ() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_ORDER_BY_AUTHOR_AZ);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public List<Map<String, Object>> getAllBooksAuthorZA() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_ORDER_BY_AUTHOR_ZA);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public List<Map<String, Object>> getAllBooksPriceAsc() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_ORDER_BY_PRICE_ASC);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public List<Map<String, Object>> getAllBooksPriceDesc() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_BOOKS_ORDER_BY_PRICE_DESC);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}
}
