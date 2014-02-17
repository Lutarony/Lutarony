package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IUserBO;
import fr.lutarony.model.User;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "#";
	private static final String ERROR = "#";

	@ManagedProperty(value = "#{UserBO}")
	IUserBO userBO;

	List<User> userList;

	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;

	public String addUser() {
		try {
			User user = new User();
			user.setId(getId());
			user.setName(getName());
			user.setSurname(getSurname());
			user.setEmail(getEmail());
			user.setPassword(getPassword());
			getUserBO().createUser(user);
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

	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserBO().getAllUsers());
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTotalUsers() {
		return getUserList().size();
	}

	public void clear() {
		this.name = "";
		this.surname = "";
		this.email = "";
		this.password = "";
	}

}
