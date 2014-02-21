package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IEventBO;
import fr.lutarony.business.definition.IUserBO;
import fr.lutarony.model.Event;
import fr.lutarony.model.User;

@ManagedBean(name = "eventBean")
@SessionScoped
public class EventBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "#";
	private static final String ERROR = "#";

	@ManagedProperty(value = "#{EventBO}")
	IEventBO eventBO;
	@ManagedProperty(value = "#{UserBO}")
	IUserBO userBO;

	List<Event> eventList;

	private int id;
	private String name;
	private User user;
	private String message = "";

	public String addEvent() {
		try {
			Event event = new Event();
			event.setName(getName());
			event.setUser(getUser());
			getEventBO().createEvent(event);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void save(AjaxBehaviorEvent event) {
		// default user 1 beacause there is no login feature... we consider the
		// current session is the user 1
		User u = getUserBO().findUser(1);

		Event e = new Event(getName(), u);
		getEventBO().createEvent(e);
	}

	public List<Event> getEventsList() {
		eventList = new ArrayList<Event>();
		eventList.addAll(getEventBO().getAllEvents());
		return eventList;
	}

	public IEventBO getEventBO() {
		return eventBO;
	}

	public void setEventBO(IEventBO eventBO) {
		this.eventBO = eventBO;
	}

	public IUserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(IUserBO userBO) {
		this.userBO = userBO;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
