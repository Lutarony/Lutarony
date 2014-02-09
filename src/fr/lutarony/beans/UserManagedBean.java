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


@ManagedBean(name = "userMB")
@RequestScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@ManagedProperty(value = "#{UserService}")
	IUserBO userService;

	List<User> userList;

	private int id;
	private String name;
	private String surname;
	private String username;
	private String password;

	public String addUser() {
		try {
			User user = new User();
			user.setId(getId());
			user.setName(getName());
			user.setSurname(getSurname());
			getUserService().addUser(user);
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
		userList.addAll(getUserService().getUsers());
		return userList;
	}

	public IUserBO getUserService() {
		return userService;
	}

	public void setUserService(IUserBO userService) {
		this.userService = userService;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
