package fr.lutarony.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "weighing")
public class Weighing {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "weight", nullable = false)
	private Double weight;

	@Column(name = "lot_nb")
	private int lotNb;

	@Column(name = "date", nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	private Timestamp date;

	@ManyToOne()
	@JoinColumn(name = "tour_id")
	private Tournament tournament;

	@OneToOne()
	@JoinColumn(name = "wrestler_id")
	private Wrestler wrestler;

	/**** CONSTRUCTOR ****/

	public Weighing(){
		
	}
	
	public Weighing(int id, Double weight, int lotNb, Timestamp date,
			Tournament tournament, Wrestler wrestler) {
		super();
		this.id = id;
		this.weight = weight;
		this.lotNb = lotNb;
		this.date = date;
		this.tournament = tournament;
		this.wrestler = wrestler;
	}

	/**** GETTERS AND SETTERS ****/

	public String getWeightValue() {
		if (weight == null || weight == 0.0) {
			return "- -";
		}

		return weight.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Wrestler getWrestler() {
		return wrestler;
	}

	public void setWrestler(Wrestler wrestler) {
		this.wrestler = wrestler;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getLotNb() {
		return lotNb;
	}

	public void setLotNb(int lotNb) {
		this.lotNb = lotNb;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Weighing [id=" + id + ", weight=" + weight + ", lotNb=" + lotNb
				+ ", date=" + date + ", tournament=" + tournament
				+ ", wrestler=" + wrestler + "]";
	}

}