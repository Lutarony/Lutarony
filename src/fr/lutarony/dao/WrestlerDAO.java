package fr.lutarony.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Wrestler;
import fr.lutarony.util.CategoryType;

public class WrestlerDAO extends DAO<Wrestler> {

	public WrestlerDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public WrestlerDAO() {
		super();
	}

	@Override
	public boolean create(Wrestler obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(Wrestler obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Wrestler obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Wrestler find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Wrestler where id=?").setParameter(0, id)
				.list();
		return (Wrestler) list.get(0);
	}

	@Override
	public List<Wrestler> getAll() {
		List list = getSessionFactory().getCurrentSession()
				.createCriteria(Wrestler.class).list();
		return list;
	}

	public List<Wrestler> getWrestlerByCategory(CategoryType category) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("SELECT * FROM Wrestler WHERE category=?")
				.setParameter(0, category.toString()).list();
		return list;
	}

}