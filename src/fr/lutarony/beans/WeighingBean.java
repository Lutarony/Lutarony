package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IWeighingBO;
import fr.lutarony.model.Tournament;
import fr.lutarony.model.Weighing;
import fr.lutarony.model.Wrestler;
import fr.lutarony.util.CategoryType;

@ManagedBean(name = "weighingBean")
@SessionScoped
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
	private String weight;
	private String lotNb;
	private Timestamp date;

	private int tolerance;
	private Double finalWeight;

	String action;

	public String addWeighing() {
		try {
			/*
			 * Weighing weighing = new Weighing(); weighing.setId(getId());
			 * weighing.setTournament(getTour());
			 * weighing.setWrestler(getWrestler());
			 * weighing.setWeight(getWeight()); weighing.setLotNb(getLotNb());
			 * weighing.setDate(getDate());
			 */
			// clear();
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public boolean getCategoryValue() {
		return CategoryType.isCategory("POUSin");
	}

	public void loadDatas(ComponentSystemEvent event) {
		Weighing w = getWeighingBO().findWeighing(getId());
		setWrestler(w.getWrestler());
		setWeight(w.getWeight().toString());
		setLotNb(String.valueOf(w.getLotNb()));
	}

	public List<Weighing> getWeighingsListOrderBySurname() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getAllOrderBySurname());
		return weighingList;
	}

	public List<Weighing> getWeighingsByPoussin() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(
				CategoryType.POUSSIN));
		return weighingList;
	}

	public List<Weighing> getWeighingsByMinime() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(
				CategoryType.MINIME));
		return weighingList;
	}

	public List<Weighing> getWeighingsByBenjamin() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(
				CategoryType.BENJAMIN));
		return weighingList;
	}

	public List<Weighing> getWeighingsByCadet() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(
				CategoryType.CADET));
		return weighingList;
	}

	public List<Weighing> getWeighingsByJunior() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(
				CategoryType.JUNIOR));
		return weighingList;
	}

	public List<Weighing> getWeighingsBySenior() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getWeighingsByCategory(
				CategoryType.SENIOR));
		return weighingList;
	}

	/*public void attrListener(AjaxBehaviorEvent event) {

		this.id = (Integer) event.getComponent().getAttributes()
				.get("selectedWeighingId");
		Weighing w = getWeighingBO().findWeighing(getId());
		setTour(w.getTournament());
		setWrestler(w.getWrestler());
		setWeight(w.getWeight().toString());
		setLotNb(String.valueOf(w.getLotNb()));
		setDate(w.getDate());
		setTolerance(CategoryType.getTolerance(w.getWrestler().getCategory()));
		setFinalWeight(Double.valueOf(getWeight()) - getTolerance());
	}*/

	public void clear(AjaxBehaviorEvent event) {
		this.tolerance = 0;
		this.weight = "0";
		this.finalWeight = 0.0;
		this.lotNb = "0";
	}

	/*public void save(AjaxBehaviorEvent event) {
		// update wrestler category weight
		Weighing w = new Weighing(getId(), Double.valueOf(getWeight()),
				Integer.valueOf(getLotNb()), getDate(), getTour(), getWrestler());
		getWeighingBO().updateWeight(w);
	}*/

	/*public void update(AjaxBehaviorEvent event) {
		if (!getWeight().isEmpty()) {
			Double weight = Double.valueOf(getWeight());
			Double newFinalWeight = weight - getTolerance();
			setFinalWeight(newFinalWeight);
		} else {
			setFinalWeight(0.0);
		}
	}*/

	public String saver() {
		return "#";
	}

	public String getLoadDetails() {

		return "#";
	}

	/**** GETTERS AND SETTERS ****/

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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLotNb() {
		return lotNb;
	}

	public void setLotNb(String lotNb) {
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

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}

	public Double getFinalWeight() {
		return finalWeight;
	}

	public void setFinalWeight(Double finalWeight) {
		this.finalWeight = finalWeight;
	}

}
