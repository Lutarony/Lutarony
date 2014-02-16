package fr.lutarony.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.User;

@Component
public class UserDAO extends DAO<User> {

	public UserDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public UserDAO() {
		super();
	}

	@Override
	public boolean create(User obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(User obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(User obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User where id=?").setParameter(0, id).list();
		return (User) list.get(0);
	}

	@Override
	public List<User> getAll() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User").list();
		return list;
	}

}