package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.IEventBO;
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
public class EventBO implements IEventBO {

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
	public void createEvent(Event event) {
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
	public void deleteEvent(Event event) {
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
	public void updateEvent(Event event) {
		getEventDAO().update(event);
	}

	/**
	 * Get Event
	 * 
	 * @param int Event Id
	 */
	@Override
	public Event findEvent(int id) {
		return getEventDAO().find(id);
	}

	/**
	 * Get Event List
	 * 
	 */
	@Override
	public List<Event> getAllEvents() {
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