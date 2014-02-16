package fr.lutarony.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.persistence.Id;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.ILoginBO;
import fr.lutarony.model.Login;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "admin";
	private static final String ERROR = "error";

	@ManagedProperty(value = "#{LoginBO}")
	ILoginBO loginBO;

	List<Login> loginList;

	@Id
	private int id;
	private String username;
	private String password;

	public String addLogin() {
		try {

			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public List<Login> getLoginList() {
		loginList = new ArrayList<Login>();
		loginList.addAll(getLoginBO().getAllLogins());
		return loginList;
	}

	public ILoginBO getLoginBO() {
		return loginBO;
	}

	public void setLoginBO(ILoginBO loginBO) {
		this.loginBO = loginBO;
	}

	public void setLoginList(List<Login> loginList) {
		this.loginList = loginList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
