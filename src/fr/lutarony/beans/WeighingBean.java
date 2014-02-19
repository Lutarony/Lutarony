package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

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
	private Double weight;
	private int lotNb;
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
		setWeight(w.getWeight());
		setLotNb(w.getLotNb());
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

	public void attrListener(ActionEvent event) {

		this.id = (Integer) event.getComponent().getAttributes()
				.get("selectedWeighingId");

	}

	public void reset(AjaxBehaviorEvent event) {
		setWeight(0.0);
		setTolerance(0);
		setFinalWeight(0.0);
	}

	public void getSave() {
		Weighing w = new Weighing(getId(), getFinalWeight(), getLotNb(),
				getDate(), getTour(), getWrestler());
		getWeighingBO().updateWeighing(w);
	}

	public String getLoadDetails() {
		Weighing w = getWeighingBO().findWeighing(getId());
		setTour(w.getTournament());
		setWrestler(w.getWrestler());
		setWeight(w.getWeight());
		setLotNb(w.getLotNb());
		setDate(w.getDate());
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
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
