package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import fr.lutarony.business.definition.ITournamentBO;
import fr.lutarony.model.Event;
import fr.lutarony.model.Tournament;
import fr.lutarony.util.Wrestling;

@ManagedBean(name = "tournamentBean")
@SessionScoped
public class TournamentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_CREATE = "The tournament '%s' has been created successfully.";

	@ManagedProperty(value = "#{TournamentBO}")
	ITournamentBO tournamentBO;

	List<Tournament> tournamentsList;

	private int id;
	private String name;
	private Event event;
	private Wrestling type;
	private Date date;

	private String message = "";

	private boolean displayErrorMessage = false;
	private boolean displaySuccessMessage = false;
	
	private List<Wrestling> typeList;
	
	
	@PostConstruct
	public void initIt() throws Exception {
		setTypeList(Arrays.asList(Wrestling.values()));
	}

	public void save(AjaxBehaviorEvent event) {
		
		Tournament newTournament = new Tournament(getName(), getType(), getDate(),
				getEvent());
		try {
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

	public List<Tournament> getTournamentsList() {
		tournamentsList = new ArrayList<Tournament>();
		tournamentsList.addAll(getTournamentBO().getAllTournaments());
		return tournamentsList;
	}

	public void setTournamentsList(List<Tournament> tournamentsList) {
		this.tournamentsList = tournamentsList;
	}

	/** GETTERS ADN SETTERS **/

	public ITournamentBO getTournamentBO() {
		return tournamentBO;
	}

	public void setTournamentBO(ITournamentBO tournamentBO) {
		this.tournamentBO = tournamentBO;
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

	public Wrestling getType() {
		return type;
	}

	public void setType(Wrestling type) {
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

	public List<Wrestling> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Wrestling> typeList) {
		this.typeList = typeList;
	}
	
	

}
