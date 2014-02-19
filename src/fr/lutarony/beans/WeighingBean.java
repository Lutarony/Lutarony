package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IWeighingBO;
import fr.lutarony.model.Tournament;
import fr.lutarony.model.Weighing;
import fr.lutarony.model.Wrestler;
import fr.lutarony.util.CategoryType;

@ManagedBean(name = "weighingBean")
public class WeighingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "#";
	private static final String ERROR = "#";

	@ManagedProperty(value = "#{WeighingBO}")
	IWeighingBO weighingBO;

	List<Weighing> weighingList;

	private int id;
	private Tournament tour;
	private Wrestler wrestler;
	private double weight;
	private int lotNb;
	private Timestamp date;

	public String addWeighing() {
		try {
			Weighing weighing = new Weighing();
			weighing.setId(getId());
			weighing.setTournament(getTour());
			weighing.setWrestler(getWrestler());
			weighing.setWeight(getWeight());
			weighing.setLotNb(getLotNb());
			weighing.setDate(getDate());
			//clear();
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void reset() {
	}
	
	public boolean getCategoryValue(){
		return CategoryType.isCategory("POUSin");
	}

	public List<Weighing> getWeighingsList() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getAllWeighings());
		return weighingList;
	}
	
	public List<Weighing> getWeighingsByPoussin() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(CategoryType.POUSSIN));
		return weighingList;
	}
	
	public List<Weighing> getWeighingsByMinime() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(CategoryType.MINIME));
		return weighingList;
	}
	
	public List<Weighing> getWeighingsByBenjamin() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(CategoryType.BENJAMIN));
		return weighingList;
	}
	
	public List<Weighing> getWeighingsByCadet() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(CategoryType.CADET));
		return weighingList;
	}
	
	public List<Weighing> getWeighingsByJunior() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(CategoryType.JUNIOR));
		return weighingList;
	}
	
	public List<Weighing> getWeighingsBySenior() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(CategoryType.SENIOR));
		return weighingList;
	}

	public void setWeighingsList(List<Weighing> weighingList) {
		this.weighingList = weighingList;
	}

	public IWeighingBO getWeighingBO() {
		return weighingBO;
	}

	public void setWeighingBO(IWeighingBO weighingBO) {
		this.weighingBO = weighingBO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tournament getTour() {
		return tour;
	}

	public void setTour(Tournament tour) {
		this.tour = tour;
	}

	public Wrestler getWrestler() {
		return wrestler;
	}

	public void setWrestler(Wrestler wrestler) {
		this.wrestler = wrestler;
	}

	public double getWeight() {
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

	public List<Weighing> getWeighingList() {
		return weighingList;
	}

	public void setWeighingList(List<Weighing> weighingList) {
		this.weighingList = weighingList;
	}

}
