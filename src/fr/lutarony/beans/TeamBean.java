package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import fr.lutarony.business.definition.ITeamBO;
import fr.lutarony.model.Team;

@ManagedBean(name = "teamBean")
@SessionScoped
public class TeamBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_CREATE = "The team '%s' has been created successfully.";
	private static final String EMPTY_FIELD = "A name is required";

	@ManagedProperty(value = "#{TeamBO}")
	ITeamBO teamBO;

	List<Team> teamsList;

	private int id;
	private String name;
	private String coach;
	private String adress;
	private String city;
	private String code;
	private String country;
	private String phone;

	// Messages
	private String message = "";
	private boolean displayErrorMessage = false;
	private boolean displaySuccessMessage = false;

	

	// save the tournament
	public void save(AjaxBehaviorEvent event) {

		if (getName().isEmpty()) {
			setMessage(EMPTY_FIELD);
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
			return;
		}

		try {
			Team newTeam = new Team(getName(), getCoach(), getAdress(),
					getCity(), getCode(), getCountry(), getPhone());
			getTeamBO().createTeam(newTeam);
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
		setAdress("");
		setCoach("");
		setCode("");
		setCountry("");
		setPhone("");
		setDisplayErrorMessage(false);
		setDisplaySuccessMessage(false);
	}

	public List<Team> getTeamsListOrderByName() {
		teamsList = new ArrayList<Team>();
		teamsList.addAll(getTeamBO().getAllOrderByName());
		return teamsList;
	}

	

	/** GETTERS AND SETTERS **/

	public int getNbWrestler(int teamId) {
		Team t = getTeamBO().findTeam(teamId);
		if (t != null) {
			return t.getWrestlers().size();
		} else {
			return 0;
		}
	}

	public List<Team> getTeamsList() {
		teamsList = new ArrayList<Team>();
		teamsList.addAll(getTeamBO().getAllTeams());
		return teamsList;
	}

	public ITeamBO getTeamBO() {
		return teamBO;
	}

	public void setTeamBO(ITeamBO teamBO) {
		this.teamBO = teamBO;
	}

	public void setTeamsList(List<Team> teamList) {
		this.teamsList = teamList;
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

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
