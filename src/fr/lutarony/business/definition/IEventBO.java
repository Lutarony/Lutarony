package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Event;

public interface IEventBO {

	public void addEvent(Event event);

	public void updateEvent(Event event);

	public void deleteEvent(Event event);

	public Event getEventById(int id);

	public List<Event> getEvents();

}