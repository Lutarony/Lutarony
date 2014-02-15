package fr.lutarony.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.lutarony.model.Event;

public class EventDAO implements IEventDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEvent(Event user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	@Override
	public void deleteEvent(Event user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	@Override
	public void updateEvent(Event user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	@Override
	public Event getEventById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Event where id=?").setParameter(0, id).list();
		return (Event) list.get(0);
	}

	@Override
	public List<Event> getEvents() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Event").list();
		return list;
	}

}