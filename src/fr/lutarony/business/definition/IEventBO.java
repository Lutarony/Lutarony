package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Event;

public interface IEventBO {
	public void createEvent(Event obj);

	public void updateEvent(Event obj);

	public void deleteEvent(Event obj);

	public Event findEvent(int id);

	public List<Event> getAllEvents();
}
