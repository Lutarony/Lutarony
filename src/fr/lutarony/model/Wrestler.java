package fr.lutarony.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.lutarony.util.CategoryType;

@Entity
@Table(name = "wrestler", uniqueConstraints = { @UniqueConstraint(name = "WRESTLER_IDENTITY", columnNames = {
		"NAME", "SURNAME" }) })
public class Wrestler {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@Column(name = "surname", unique = false, nullable = false)
	private String surname;

	@Column(name = "sex", unique = false, nullable = false)
	private String sex;

	@Column(name = "birth_date", unique = false, nullable = false)
	private Date birthDate;

	@Column(name = "category", unique = false, nullable = true)
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	
	@Column(name = "category_weight", unique = false, nullable = true)
	private CategoryType categoryWeight;

	@ManyToOne()
	@JoinColumn(name = "team_id")
	private Team team;

	@OneToOne(mappedBy = "wrestler")
	private Weighing weighing;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public CategoryType getCategory() {
		if (category == null) {
			return CategoryType.NONE;
		}
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public Weighing getWeighing() {
		return weighing;
	}

	public void setWeighing(Weighing weighing) {
		this.weighing = weighing;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("WRESTLER = ");
		strBuff.append("id : ").append(getId());
		strBuff.append(", name : ").append(getName());
		strBuff.append(", surname : ").append(getSurname());
		strBuff.append(", sex : ").append(getSex());
		strBuff.append(", team : ").append(getTeam());
		strBuff.append(", category : ").append(getCategory());
		return strBuff.toString();
	}
}