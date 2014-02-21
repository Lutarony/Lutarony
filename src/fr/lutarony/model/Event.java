package fr.lutarony.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	// List of TOURNAMENTS
	@OneToMany(mappedBy = "event")
	private Set<Tournament> tournaments = new HashSet<Tournament>();

	public Event(){
		
	}
	
	public Event(String name, User user) {
		super();
		this.name = name;
		this.user = user;
	}

	/**** GETTERS AND SETTERS ****/

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(Set<Tournament> tournaments) {
		this.tournaments = tournaments;
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