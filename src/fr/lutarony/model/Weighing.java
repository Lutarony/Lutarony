package fr.lutarony.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "weighing")
public class Weighing {

	private int id;
	private int tourId;
	private int wrestlerId;
	private double weight;
	private int lotNb;
	private Timestamp date;

	private Wrestler wrestler;
	private Tournament tournament;

	// List of wrestlers

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TOUR_ID", nullable = false)
	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tour_id")
	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	@Column(name = "WRESTLER_ID", nullable = false)
	public int getWrestlerId() {
		return wrestlerId;
	}

	public void setWrestlerId(int wrestlerId) {
		this.wrestlerId = wrestlerId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wrestler_id")
	public Wrestler getWrestler() {
		return wrestler;
	}

	public void setWrestler(Wrestler wrestler) {
		this.wrestler = wrestler;
	}

	@Column(name = "WEIGHT", nullable = false)
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Column(name = "LOT_NB")
	public int getLotNb() {
		return lotNb;
	}

	public void setLotNb(int lotNb) {
		this.lotNb = lotNb;
	}

	@Column(name = "DATE", nullable = false)
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}