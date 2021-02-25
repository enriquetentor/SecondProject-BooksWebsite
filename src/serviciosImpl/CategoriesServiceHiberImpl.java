package serviciosImpl;

import java.util.List;

import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.SQLConstants;
import modelo.Book;
import modelo.Categories;
import modelo.User;
import servicios.CategoriesService;

@Service
@Transactional
public class CategoriesServiceHiberImpl implements CategoriesService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerCategory(Categories category) {
		sessionFactory.getCurrentSession().save(category);
	}

	@Override
	public List<Categories> getCategories() {
		return sessionFactory.getCurrentSession().createCriteria(Categories.class).addOrder(Order.desc("id")).list();
	}

	@Override
	public List<Map<String, Object>> getCategoriesToList() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(SQLConstants.GET_CATEGORIES_TO_LIST);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		return query.list();
	}

	@Override
	public void deleteCategory(long categoryId) {
		Categories categoryDelete = (Categories) sessionFactory.getCurrentSession().get(Categories.class, categoryId);
		sessionFactory.getCurrentSession().delete(categoryDelete);
	}

	@Override
	public Categories getCategoryById(long categoryId) {
		Categories category = (Categories) sessionFactory.getCurrentSession().get(Categories.class, categoryId);
		return category;
	}

	@Override
	public void saveCategoryChanges(Categories category) {
		sessionFactory.getCurrentSession().merge(category);
	}
}
