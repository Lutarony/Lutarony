package fr.lutarony.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Wrestler;

public class WrestlerDAO extends DAO<Wrestler> {

	public WrestlerDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public WrestlerDAO() {
		super();
	}

	/*
	 * private SessionFactory sessionFactory;
	 * 
	 * public SessionFactory getSessionFactory() { return sessionFactory; }
	 * 
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 * 
	 * @Override public void addWrestler(Wrestler wrestler) {
	 * getSessionFactory().getCurrentSession().save(wrestler); }
	 * 
	 * @Override public void deleteWrestler(Wrestler wrestler) {
	 * getSessionFactory().getCurrentSession().delete(wrestler); }
	 * 
	 * @Override public void updateWrestler(Wrestler wrestler) {
	 * getSessionFactory().getCurrentSession().update(wrestler); }
	 * 
	 * @Override public Wrestler getWrestlerById(int id) { List list =
	 * getSessionFactory().getCurrentSession()
	 * .createQuery("from Wrestler where id=?").setParameter(0, id).list();
	 * return (Wrestler) list.get(0); }
	 * 
	 * @Override public List<Wrestler> getWrestlers() { List list =
	 * getSessionFactory().getCurrentSession()
	 * .createQuery("from Wrestler").list(); return list; }
	 */

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
				.createQuery("from Wrestler").list();
		return list;
	}

}