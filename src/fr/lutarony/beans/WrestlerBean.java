package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IWrestlerBO;
import fr.lutarony.model.Wrestler;

@ManagedBean(name = "wrestlerBean")
public class WrestlerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "admin";
	private static final String ERROR = "error";

	@ManagedProperty(value = "#{WrestlerBO}")
	IWrestlerBO wrestlerBO;

	List<Wrestler> wrestlerList;

	private int id;
	private String name;
	private String surname;
	private String sex;
	private Date birthDate;
	private int teamId;
	private int categoryId;


	public String addWrestler() {
		try {
			Wrestler wrestler = new Wrestler();
			wrestler.setId(getId());
			wrestler.setName(getName());
			wrestler.setSurname(getSurname());
			wrestler.setSex(getSex());
			wrestler.setBirthDate(getBirthDate());
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

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getSayWelcome() {
		if ("".equals(name) || name == null) {
			return "";
		} else {
			return "Welcome " + name;
		}
	}

	public void checkName(AjaxBehaviorEvent event) {

	}

	public void clear() {
		this.name = "";
		this.surname = "";
	}

	public int getTotalWrestlers() {
		return getWrestlerList().size();
	}

}
