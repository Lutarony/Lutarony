package fr.lutarony.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "coach", unique = false, nullable = true)
	private String coach;

	@Column(name = "adress", unique = false, nullable = true)
	private String adress;

	@Column(name = "city", unique = false, nullable = true)
	private String city;

	@Column(name = "code", unique = false, nullable = true)
	private String code;

	@Column(name = "country", unique = false, nullable = true)
	private String country;

	@Column(name = "phone", unique = false, nullable = true)
	private String phone;

	// List of WRESTLERS
	@OneToMany(mappedBy = "team",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Wrestler> wrestlers = new HashSet<Wrestler>();

	/**** CONSTRUCTORS ****/
	public Team() {
	}

	public Team(String name, String coach, String adress, String city,
			String code, String country, String phone) {
		super();
		this.name = name;
		this.coach = coach;
		this.adress = adress;
		this.city = city;
		this.code = code;
		this.country = country;
		this.phone = phone;
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

	public String getCoach() {
		if (coach == null || coach.isEmpty())
			return "- -";
		else
			return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getAdress() {
		if (adress == null || adress.isEmpty())
			return "- -";
		else
			return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {

		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {

		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		if (phone == null || phone.isEmpty())
			return "- -";
		else
			return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Wrestler> getWrestlers() {
		return wrestlers;
	}

	public void setWrestlers(Set<Wrestler> wrestlers) {
		this.wrestlers = wrestlers;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("TEAM = ");
		strBuff.append("id : ").append(getId());
		strBuff.append(", name : ").append(getName());
		strBuff.append(", coach : ").append(getCoach());
		strBuff.append(", adress : ").append(getAdress());
		strBuff.append(", city : ").append(getCity());
		strBuff.append(", code : ").append(getCode());
		strBuff.append(", country : ").append(getCountry());
		strBuff.append(", phone : ").append(getPhone());
		return strBuff.toString();
	}

}