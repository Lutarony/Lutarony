package fr.lutarony.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@OneToMany(mappedBy = "team")
	private Set<Wrestler> wrestlers = new HashSet<Wrestler>();

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
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getAdress() {
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