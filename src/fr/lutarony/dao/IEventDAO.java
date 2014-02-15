package fr.lutarony.dao;

import java.util.List;

import fr.lutarony.model.Event;

public interface IEventDAO {
	
	public Event getEventById(int id);

	public void addEvent(Event event);

	public void updateEvent(Event event);

	public void deleteEvent(Event event);

	public List<Event> getEvents();

}