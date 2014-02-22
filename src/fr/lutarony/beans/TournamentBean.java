package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import fr.lutarony.business.definition.IEventBO;
import fr.lutarony.business.definition.ITournamentBO;
import fr.lutarony.model.Event;
import fr.lutarony.model.Tournament;
import fr.lutarony.util.DateUtils;
import fr.lutarony.util.Wrestling;

@ManagedBean(name = "tournamentBean")
@SessionScoped
public class TournamentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_CREATE = "The tournament '%s' has been created successfully.";
	private static final String NAME_MISSING = "The name is required";
	private static final String INVALID_DATE = "The date is not valid";
	private static final String DATE_FORMAT = "dd/MM/yyyy";

	@ManagedProperty(value = "#{TournamentBO}")
	ITournamentBO tournamentBO;

	@ManagedProperty(value = "#{EventBO}")
	IEventBO eventBO;

	List<Tournament> tournamentsList;

	private int id;
	private String name;
	private Event event;
	private String type;
	private Date date;

	// simple inputtext from user, to replace calendar/DateType bug
	private String dateValue;

	// Messages
	private String message = "";
	private boolean displayErrorMessage = false;
	private boolean displaySuccessMessage = false;

	// default event 1 because there is no session feature... we consider the
	// current event is the event 1
	private static int CURRENT_SESSION_EVENT_ID = 1;

	// List of wrestling types
	private static Map<String, Wrestling> typesList;
	static {
		typesList = new LinkedHashMap<String, Wrestling>();
		typesList.put(Wrestling.FREE.toString(), Wrestling.FREE);
		typesList.put(Wrestling.WOMEN.toString(), Wrestling.WOMEN);
		typesList
				.put(Wrestling.GRECO_ROMANE.toString(), Wrestling.GRECO_ROMANE);
	}

	// save the tournament
	public void save(AjaxBehaviorEvent event) {

		if (getName().isEmpty()) {
			setMessage(NAME_MISSING);
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
			return;
		}

		if (getDateValue().isEmpty()
				|| !DateUtils.isValid(getDateValue(), DATE_FORMAT)) {
			setMessage(INVALID_DATE);
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
			return;
		}
		try {

			setEvent(getEventBO().findEvent(CURRENT_SESSION_EVENT_ID));
			setDate(new Date(DateUtils.getDate(getDateValue(), DATE_FORMAT)
					.getTime()));

			Tournament newTournament = new Tournament(getName(),
					Wrestling.valueOf(getType()), getDate(), getEvent());
			getTournamentBO().createTournament(newTournament);
			setMessage(SUCCESS_CREATE.replace("%s", getName()));
			setDisplaySuccessMessage(true);
			setDisplayErrorMessage(false);
		} catch (Exception ex) {
			setMessage(ex.getMessage());
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
		}
	}

	public void clear() {
		setName("");
		setDateValue("");
		setType(Wrestling.FREE.toString());
		setDisplayErrorMessage(false);
		setDisplaySuccessMessage(false);
	}
	
	public String getCurrentEventName(){
		// we suppose this current event, which has id 1
		Event currentEvent = getEventBO().findEvent(CURRENT_SESSION_EVENT_ID);
		return currentEvent.getName();
	}

	/** GETTERS ADN SETTERS **/

	public List<Tournament> getTournamentsList() {
		tournamentsList = new ArrayList<Tournament>();
		tournamentsList.addAll(getTournamentBO().getAllTournaments());
		return tournamentsList;
	}

	public void setTournamentsList(List<Tournament> tournamentsList) {
		this.tournamentsList = tournamentsList;
	}

	public ITournamentBO getTournamentBO() {
		return tournamentBO;
	}

	public void setTournamentBO(ITournamentBO tournamentBO) {
		this.tournamentBO = tournamentBO;
	}

	public IEventBO getEventBO() {
		return eventBO;
	}

	public void setEventBO(IEventBO eventBO) {
		this.eventBO = eventBO;
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

	public List<Tournament> getTournament() {
		return tournamentsList;
	}

	public void setTournament(List<Tournament> tournament) {
		this.tournamentsList = tournament;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Map<String, Wrestling> getTypesList() {
		return typesList;
	}

	public String getDateValue() {
		return dateValue;
	}

	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}

}
