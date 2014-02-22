package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

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
	private static final String SUCCESS_CREATE = "The event '%s' has been created successfully.";

	@ManagedProperty(value = "#{EventBO}")
	IEventBO eventBO;
	@ManagedProperty(value = "#{UserBO}")
	IUserBO userBO;

	List<Event> eventList;

	private int id;
	private String name;
	private User currentUser;
	private String message = "";

	private boolean displayErrorMessage = false;
	private boolean displaySuccessMessage = false;

	@PostConstruct
	public void initIt() throws Exception {
		// default user 1 beacause there is no login feature... we consider the
		// current session is the user 1
		this.currentUser = getUserBO().findUser(1);
	}

	public void save(AjaxBehaviorEvent event) {

		Event e = new Event(getName(), currentUser);
		try {
			getEventBO().createEvent(e);
			setMessage(SUCCESS_CREATE.replace("%s", getName()));
			setDisplaySuccessMessage(true);
			setDisplayErrorMessage(false);
		} catch (Exception ex) {
			setMessage(ex.getMessage());
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
		}
	}

	public List<Event> getEventsList() {
		eventList = new ArrayList<Event>();
		eventList.addAll(getEventBO().getAllEvents());
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	/** GETTERS ADN SETTERS **/

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
		return currentUser;
	}

	public void setUser(User user) {
		this.currentUser = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getDisplayErrorMessage() {
		return displayErrorMessage;
	}

	public void setDisplayErrorMessage(boolean display) {
		this.displayErrorMessage = display;
	}

	public boolean getDisplaySuccessMessage() {
		return displaySuccessMessage;
	}

	public void setDisplaySuccessMessage(boolean display) {
		this.displaySuccessMessage = display;
	}

}
