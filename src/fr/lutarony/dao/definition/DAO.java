package fr.lutarony.dao.definition;

import java.util.List;

import org.hibernate.SessionFactory;

public abstract class DAO<T> {

	protected SessionFactory sessionFactory;

	public DAO() {
	}

	public DAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);

	public abstract T find(int id);

	public abstract List<T> getAll();
}
