package fr.lutarony.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	private int id;
	private String username;
	private String password;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "USERNAME", nullable = false)
	public String getName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPasswordId() {
		return password;
	}

	public void setPasswordId(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(getId());
		strBuff.append(", username : ").append(getName());
		return strBuff.toString();
	}
}