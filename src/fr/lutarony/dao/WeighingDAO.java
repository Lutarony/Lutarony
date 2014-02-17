package fr.lutarony.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Weighing;
import fr.lutarony.util.CategoryType;

public class WeighingDAO extends DAO<Weighing> {

	public WeighingDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public WeighingDAO() {
		super();
	}

	@Override
	public boolean create(Weighing obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(Weighing obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Weighing obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Weighing find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Wrestler where id=?").setParameter(0, id)
				.list();
		return (Weighing) list.get(0);
	}

	@Override
	public List<Weighing> getAll() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Weighing").list();
		return list;
	}

	public List<Weighing> getWeighingByCategory(CategoryType category) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("SELECT * FROM Weighing WHERE category=?")
				.setParameter(0, category.toString()).list();
		return list;
	}

}