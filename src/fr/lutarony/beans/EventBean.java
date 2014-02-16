package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IEventBO;
import fr.lutarony.model.Event;

@ManagedBean(name = "eventBean")
@RequestScoped
public class EventBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "admin";
	private static final String ERROR = "error";

	@ManagedProperty(value = "#{EventBO}")
	IEventBO eventBO;

	List<Event> eventList;

	private int id;
	private String name;
	private int teamId;

	public String addEvent() {
		try {

			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public List<Event> getEventList() {
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

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

}
