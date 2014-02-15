package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.IEventBO;
import fr.lutarony.dao.IEventDAO;
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
	IEventDAO eventDAO;

	/**
	 * Add Event
	 * 
	 * @param Event
	 *            event
	 */
	@Transactional(readOnly = false)
	@Override
	public void addEvent(Event event) {
		getEventDAO().addEvent(event);
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
		getEventDAO().deleteEvent(event);
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
		getEventDAO().updateEvent(event);
	}

	/**
	 * Get Event
	 * 
	 * @param int Event Id
	 */
	@Override
	public Event getEventById(int id) {
		return getEventDAO().getEventById(id);
	}

	/**
	 * Get Event List
	 * 
	 */
	@Override
	public List<Event> getEvents() {
		return getEventDAO().getEvents();
	}

	/**
	 * Get Event DAO
	 * 
	 * @return IEventDAO - Event DAO
	 */
	public IEventDAO getEventDAO() {
		return eventDAO;
	}

	/**
	 * Set Event DAO
	 * 
	 * @param IEventBO
	 *            - Event DAO
	 */
	public void setEventDAO(IEventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
}