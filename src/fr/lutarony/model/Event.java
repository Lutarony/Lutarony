package fr.lutarony.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int userId;

	@Transient
	private User user;
	//List of tournaments

	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = false, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "USER_ID", unique = false, nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int UserId) {
		this.userId = UserId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User User) {
		this.user = User;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("EVENT = ");
		strBuff.append("id : ").append(getId());
		strBuff.append(", name : ").append(getName());
		strBuff.append(", creator : ").append(getUser());
		return strBuff.toString();
	}
}