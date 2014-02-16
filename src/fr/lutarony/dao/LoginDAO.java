package fr.lutarony.dao;

import java.util.List;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Login;

public class LoginDAO extends DAO<Login> {

	@Override
	public boolean create(Login obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(Login obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Login obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Login find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Login where id=?").setParameter(0, id)
				.list();
		return (Login) list.get(0);
	}

	@Override
	public List<Login> getAll() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Login").list();
		return list;
	}

}