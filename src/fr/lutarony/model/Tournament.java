package fr.lutarony.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.lutarony.util.Wrestling;

@Entity
@Table(name = "tournament")
public class Tournament {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@Column(name = "type", unique = false, nullable = false)
	@Enumerated(EnumType.STRING)
	private Wrestling type;

	@Column(name = "date", unique = false, nullable = false)
	private Date date;

	@ManyToOne()
	@JoinColumn(name = "event_id")
	private Event event;

	@OneToMany(mappedBy = "tournament")
	private Set<Weighing> weighings = new HashSet<Weighing>();

	/** CONSTRUCTOR **/
	
	public Tournament (){
		
	}

	public Tournament(String name, Wrestling type, Date date, Event event) {
		super();
		this.name = name;
		this.type = type;
		this.date = date;
		this.event = event;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Wrestling getType() {
		return type;
	}

	public void setType(Wrestling type) {
		this.type = type;
	}

	public Set<Weighing> getWeighings() {
		return weighings;
	}

	public void setWeighings(Set<Weighing> weighings) {
		this.weighings = weighings;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("TOURNAMENT = ");
		strBuff.append("id : ").append(getId());
		strBuff.append(", event : ").append(getEvent());
		strBuff.append(", type : ").append(getType());
		strBuff.append(", date : ").append(getDate());
		return strBuff.toString();
	}

}