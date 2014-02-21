package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IWeighingBO;
import fr.lutarony.business.definition.IWrestlerBO;
import fr.lutarony.model.Team;
import fr.lutarony.model.Weighing;
import fr.lutarony.model.Wrestler;
import fr.lutarony.util.CategoryType;

@ManagedBean(name = "wrestlerBean")
@SessionScoped
public class WrestlerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "#";
	private static final String ERROR = "#";

	@ManagedProperty(value = "#{WrestlerBO}")
	IWrestlerBO wrestlerBO;
	@ManagedProperty(value = "#{WeighingBO}")
	IWeighingBO weighingBO;
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

	// FORM fields
	private String weight;
	private int tolerance;
	private Double finalWeight;
	private Wrestler currentWrestler;

	// Supposed current tournament stored in session
	// private Tournament tournament;

	@PostConstruct
	public void initIt() throws Exception {
		// default tournament 1 because there is no session feature... we
		// consider the
		// current tournament is 1, added directly in DB
		// this.tournament = getTournamentBO().findTournament(1);
	}

	public String addWrestler() {
		try {
			Wrestler wrestler = new Wrestler();
			wrestler.setId(getId());
			wrestler.setName(getName());
			wrestler.setSurname(getSurname());
			wrestler.setSex(getSex());
			wrestler.setBirthDate(getBirthDate());
			wrestler.setTeam(getTeam());
			wrestler.setCategory(getCategory());
			getWrestlerBO().createWrestler(wrestler);
			clear();
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void reset() {
		this.setId(0);
		this.setName("");
		this.setSurname("");
	}

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

	public void update(AjaxBehaviorEvent event) {
		if (!getWeight().isEmpty()) {
			Double weight = Double.valueOf(getWeight());
			Double newFinalWeight = weight - getTolerance();
			setFinalWeight(newFinalWeight);
		} else {
			setFinalWeight(0.0);
		}
	}

	public void save(AjaxBehaviorEvent event) {
		// update wrestler category weight
		// get timstamp

		Weighing w = new Weighing(Double.valueOf(getWeight()),
				Integer.valueOf(getLotNb()), // getWeighing().getTournament(),
				getCurrentWrestler());
		getWeighingBO().createWeighing(w);;
	}

	/** GETTERS AND SETTERS **/
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

}
