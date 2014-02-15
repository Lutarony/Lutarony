package fr.lutarony.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.lutarony.model.Wrestler;

public class WrestlerDAO implements IWrestlerDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addWrestler(Wrestler wrestler) {
		getSessionFactory().getCurrentSession().save(wrestler);
	}

	@Override
	public void deleteWrestler(Wrestler wrestler) {
		getSessionFactory().getCurrentSession().delete(wrestler);
	}

	@Override
	public void updateWrestler(Wrestler wrestler) {
		getSessionFactory().getCurrentSession().update(wrestler);
	}

	@Override
	public Wrestler getWrestlerById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Wrestler where id=?").setParameter(0, id).list();
		return (Wrestler) list.get(0);
	}

	@Override
	public List<Wrestler> getWrestlers() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Wrestler").list();
		return list;
	}

}