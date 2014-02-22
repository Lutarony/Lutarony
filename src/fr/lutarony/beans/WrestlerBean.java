package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import fr.lutarony.business.definition.ITeamBO;
import fr.lutarony.business.definition.IWeighingBO;
import fr.lutarony.business.definition.IWrestlerBO;
import fr.lutarony.model.Team;
import fr.lutarony.model.Weighing;
import fr.lutarony.model.Wrestler;
import fr.lutarony.util.CategoryType;
import fr.lutarony.util.DateUtils;

@ManagedBean(name = "wrestlerBean")
@SessionScoped
public class WrestlerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_CREATE = "The wrestler '%s' has been created successfully. The wrestler will fight in %c category.";
	private static final String NAME_MISSING = "The name is required";
	private static final String SURNAME_MISSING = "The surname is required";
	private static final String INVALID_DATE = "The date is not valid";
	private static final String DATE_FORMAT = "dd/MM/yyyy";

	@ManagedProperty(value = "#{WrestlerBO}")
	IWrestlerBO wrestlerBO;
	@ManagedProperty(value = "#{WeighingBO}")
	IWeighingBO weighingBO;
	@ManagedProperty(value = "#{TeamBO}")
	ITeamBO teamBO;
	// @ManagedProperty(value = "#{TournamentBO}")
	// ITournamentBO tournamentBO;

	List<Wrestler> wrestlerList;

	private int id;
	private String name;
	private String surname;
	private String sex;
	private Date birthDate;
	private Team team;
	private CategoryType category;
	private String lotNb;
	private Weighing weighing;
	private String weight;
	private int tolerance;
	private Double finalWeight;
	private Wrestler currentWrestler;

	private String birthDateValue;

	// Messages
	private String message = "";
	private boolean displayErrorMessage = false;
	private boolean displaySuccessMessage = false;

	// Supposed current tournament stored in session
	// private Tournament tournament;

	private String selectedTeam;
	private Map<String, Team> teamsMap = new HashMap<String, Team>(); 

	// List of wrestling types

	public void reset() {
		this.setId(0);
		this.setName("");
		this.setSurname("");
	}

	// get the list of teams
	public Map<String, Team> getTeamsMapOrderByName() {
		List<Team> orederedList =  getTeamBO().getAllOrderByName();
		for (Team t : orederedList) {
			getTeamsMap().put(t.getName(), t);
		}
		
		return teamsMap;
	}

	// Method used in Weighing part : click on item in the wrestlers list, to
	// edit weighing
	public void attrListener(AjaxBehaviorEvent event) {

		setId((Integer) event.getComponent().getAttributes()
				.get("selectedWrestlerId"));
		Wrestler w = getWrestlerBO().findWrestler(getId());
		setWeighing(w.getWeighing());
		setTolerance(CategoryType.getTolerance(w.getCategory()));
		if (w.getWeighing() != null) {
			setLotNb(String.valueOf(w.getWeighing().getLotNb()));
			setWeight(String.valueOf(w.getWeighing().getWeight()));
			setFinalWeight(Double.valueOf(w.getWeighing().getWeight())
					- getTolerance());
		} else {
			setLotNb("0");
			setWeight("0");
			setFinalWeight(0.0);
		}
		setCurrentWrestler(w);

	}

	public void updateFinalWeight(AjaxBehaviorEvent event) {
		if (!getWeight().isEmpty()) {
			Double weight = Double.valueOf(getWeight());
			Double newFinalWeight = weight - getTolerance();
			setFinalWeight(newFinalWeight);
		} else {
			setFinalWeight(0.0);
		}
	}

	public void saveWeighing(AjaxBehaviorEvent event) {
		//update weight category of the current wrestler
		getCurrentWrestler().setCategoryWeight(CategoryType.getCategory(getCurrentWrestler().getBirthDate(), getFinalWeight()));
		
		Weighing w = new Weighing(Double.valueOf(getWeight()),
				Integer.valueOf(getLotNb()), // getWeighing().getTournament(),
				getCurrentWrestler());
		getWeighingBO().createWeighing(w);

	}

	public void saveWrestler(AjaxBehaviorEvent event) {
		if (getName().isEmpty()) {
			setMessage(NAME_MISSING);
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
			return;
		}

		if (getSurname().isEmpty()) {
			setMessage(SURNAME_MISSING);
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
			return;
		}

		if (getBirthDateValue().isEmpty()
				|| !DateUtils.isValid(getBirthDateValue(), DATE_FORMAT)) {
			setMessage(INVALID_DATE);
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
			return;
		}

		try {
			//set team
			setTeam(getTeamsMap().get(getSelectedTeam()));
			
			//set the birthDate
			setBirthDate(new Date(DateUtils.getDate(getBirthDateValue(), DATE_FORMAT)
					.getTime()));
			
			//get the category according the bithDate
			Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(getBirthDate());   
			setCategory(CategoryType.getCategory(calendar.get(Calendar.YEAR)));
			Wrestler w = new Wrestler(getName(), getSurname(), getSex(), getBirthDate(), getCategory(), getTeam());
			getWrestlerBO().createWrestler(w);
			setMessage(SUCCESS_CREATE.replace("%s", getName() + " "
					+ getSurname()));
			setDisplaySuccessMessage(true);
			setDisplayErrorMessage(false);
		} catch (Exception ex) {
			setMessage(ex.getMessage());
			setDisplaySuccessMessage(false);
			setDisplayErrorMessage(true);
		}

	}

	/** GETTERS AND SETTERS **/

	public List<Wrestler> getWrestlerList() {
		wrestlerList = new ArrayList<Wrestler>();
		wrestlerList.addAll(getWrestlerBO().getAllWrestlers());
		return wrestlerList;
	}

	public List<Wrestler> getWrestlersListOrderBySurname() {
		wrestlerList = new ArrayList<Wrestler>();
		wrestlerList.addAll(getWrestlerBO().getAllOrderBySurname());
		return wrestlerList;
	}

	public IWrestlerBO getWrestlerBO() {
		return wrestlerBO;
	}

	public void setWrestlerBO(IWrestlerBO wrestlerBO) {
		this.wrestlerBO = wrestlerBO;
	}

	public void setWrestlerList(List<Wrestler> wrestlerList) {
		this.wrestlerList = wrestlerList;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}

	public void clear() {
		this.name = "";
		this.surname = "";
	}

	public int getTotalWrestlers() {
		return getWrestlerList().size();
	}

	public Weighing getWeighing() {
		return weighing;
	}

	public void setWeighing(Weighing weighing) {
		this.weighing = weighing;
	}

	public Double getFinalWeight() {
		return finalWeight;
	}

	public void setFinalWeight(Double finalWeight) {
		this.finalWeight = finalWeight;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLotNb() {
		return lotNb;
	}

	public void setLotNb(String lotNb) {
		this.lotNb = lotNb;
	}

	public IWeighingBO getWeighingBO() {
		return weighingBO;
	}

	public void setWeighingBO(IWeighingBO weighingBO) {
		this.weighingBO = weighingBO;
	}

	public Wrestler getCurrentWrestler() {
		return currentWrestler;
	}

	public void setCurrentWrestler(Wrestler currentWrestler) {
		this.currentWrestler = currentWrestler;
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

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public String getBirthDateValue() {
		return birthDateValue;
	}

	public void setBirthDateValue(String birthDateValue) {
		this.birthDateValue = birthDateValue;
	}

	public Map<String, Team> getTeamsMap() {
		return teamsMap;
	}

	public void setTeamsMap(Map<String, Team> teamsMap) {
		this.teamsMap = teamsMap;
	}

	public ITeamBO getTeamBO() {
		return teamBO;
	}

	public void setTeamBO(ITeamBO teamBO) {
		this.teamBO = teamBO;
	}
	
	
}
