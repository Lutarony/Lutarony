package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import fr.lutarony.business.definition.ITeamBO;
import fr.lutarony.model.Team;

@ManagedBean(name = "teamBean")
@RequestScoped
public class TeamBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "#";
	private static final String ERROR = "#";

	@ManagedProperty(value = "#{TeamBO}")
	ITeamBO teamBO;

	List<Team> teamList;

	private int id;
	private String name;
	private String coach;
	private String adress;
	private String city;
	private String code;
	private String country;
	private String phone;

	public String addTeamBean() {
		Team team = new Team();
		team.setName(getName());
		team.setCoach(getCoach());

		getTeamBO().createTeam(team);

		RequestContext.getCurrentInstance().closeDialog(team);
		/*
		 * FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
		 * "Team created :", team.getName());
		 * FacesContext.getCurrentInstance().addMessage(null, message);
		 */
		return team.getName();
	}

	public void openAddTeamView() {
		RequestContext.getCurrentInstance().openDialog("add-team.xhtml");
	}

	public String editTeamBean() {
		Team team = new Team();
		team.setName(getName());
		team.setCoach(getCoach());
		getTeamBO().updateTeam(team);

		RequestContext.getCurrentInstance().closeDialog(team);
		/*
		 * FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
		 * "Team edited :", team.getName());
		 * FacesContext.getCurrentInstance().addMessage(null, message);
		 */

		return team.getName();
	}

	public void openEditTeamView() {
		RequestContext.getCurrentInstance().openDialog("edit-team");
	}

	public List<Team> getTeamList() {
		teamList = new ArrayList<Team>();
		teamList.addAll(getTeamBO().getAllTeams());
		return teamList;
	}

	public ITeamBO getTeamBO() {
		return teamBO;
	}

	public void setTeamBO(ITeamBO teamBO) {
		this.teamBO = teamBO;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
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
}
