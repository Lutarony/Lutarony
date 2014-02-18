package fr.lutarony.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.lutarony.util.Wrestling;

@Entity
@Table(name = "tournament")
public class Tournament {

	private int id;
	private int eventId;
	private Wrestling type;
	private Date date;

	private Event event;

	// List of weighings

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "EVENT_ID", unique = true, nullable = false)
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Column(name = "DATE", unique = false, nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	public Wrestling getType() {
		return type;
	}

	public void setType(Wrestling type) {
		this.type = type;
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