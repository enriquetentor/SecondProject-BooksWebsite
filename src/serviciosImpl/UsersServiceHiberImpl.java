package serviciosImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.User;
import servicios.UsersService;

@Service
@Transactional
public class UsersServiceHiberImpl implements UsersService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) {
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("name", name)).add(Restrictions.eq("password", password)).uniqueResult();
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).addOrder(Order.desc("id")).list();
	}

	@Override
	public void deleteUser(long userId) {
		User userDelete = (User) sessionFactory.getCurrentSession().get(User.class, userId);
		sessionFactory.getCurrentSession().delete(userDelete);
	}

	@Override
	public User getUserById(long userId) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
		return user;
	}

	@Override
	public void saveUserChanges(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}

}
