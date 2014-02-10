package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IUserBO;
import fr.lutarony.model.User;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@ManagedProperty(value = "#{UserBO}")
	IUserBO userBO;

	List<User> userList;

	private int id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;

	public String addUser() {
		try {
			User user = new User();
			user.setId(getId());
			user.setName(getName());
			user.setSurname(getSurname());
			getUserBO().addUser(user);
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

	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserBO().getUsers());
		return userList;
	}

	public IUserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(IUserBO userBO) {
		this.userBO = userBO;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
