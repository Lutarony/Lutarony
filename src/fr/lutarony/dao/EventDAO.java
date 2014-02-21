package fr.lutarony.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Event;

public class EventDAO extends DAO<Event> {

	@Override
	public boolean create(Event obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(Event obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Event obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Event find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Event where id=?").setParameter(0, id)
				.list();
		return (Event) list.get(0);
	}

	@Override
	public List<Event> getAll() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Event").list();
		return list;
	}

	public void alreadyExists(String name) throws Exception {

		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Event.class);
		criteria.createAlias("event", "e").add(Restrictions.eq("e.name", name));
		Event e = (Event) criteria.uniqueResult();
		if (e == null)
			throw new Exception("erreur");
	}
}