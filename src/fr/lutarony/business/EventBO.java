package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.BO;
import fr.lutarony.dao.EventDAO;
import fr.lutarony.model.Event;

/**
 * 
 * Event Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Transactional(readOnly = true)
public class EventBO implements BO<Event> {

	// EventDAO is injected...
	EventDAO eventDAO;

	/**
	 * Add Event
	 * 
	 * @param Event
	 *            event
	 */
	@Transactional(readOnly = false)
	@Override
	public void create(Event event) {
		getEventDAO().create(event);
	}

	/**
	 * Delete Event
	 * 
	 * @param Event
	 *            event
	 */
	@Transactional(readOnly = false)
	@Override
	public void delete(Event event) {
		getEventDAO().delete(event);
	}

	/**
	 * Update Event
	 * 
	 * @param Event
	 *            event
	 */
	@Transactional(readOnly = false)
	@Override
	public void update(Event event) {
		getEventDAO().update(event);
	}

	/**
	 * Get Event
	 * 
	 * @param int Event Id
	 */
	@Override
	public Event find(int id) {
		return getEventDAO().find(id);
	}

	/**
	 * Get Event List
	 * 
	 */
	@Override
	public List<Event> getAll() {
		return getEventDAO().getAll();
	}

	/**
	 * Get Event DAO
	 * 
	 * @return IEventDAO - Event DAO
	 */
	public EventDAO getEventDAO() {
		return eventDAO;
	}

	/**
	 * Set Event DAO
	 * 
	 * @param IEventBO
	 *            - Event DAO
	 */
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
}