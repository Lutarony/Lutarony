package fr.lutarony.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class Wrestler {

	private int id;
	private String name;
	private String surname;
	private String email;
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

	@Column(name = "NAME", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME", unique = true, nullable = false)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "EMAIL", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "USERNAME", unique = true, nullable = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", unique = true, nullable = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(getId());
		strBuff.append(", name : ").append(getName());
		strBuff.append(", surname : ").append(getSurname());
		strBuff.append(", login : ").append(getUsername());
		return strBuff.toString();
	}
}