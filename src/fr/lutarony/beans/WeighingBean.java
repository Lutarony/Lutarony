package fr.lutarony.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.dao.DataAccessException;

import fr.lutarony.business.definition.IWeighingBO;
import fr.lutarony.model.Weighing;

@ManagedBean(name = "weighingBean")
public class WeighingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "#";
	private static final String ERROR = "#";

	@ManagedProperty(value = "#{WeighingBO}")
	IWeighingBO weighingBO;

	List<Weighing> weighingList;

	private int id;
	private int tourId;
	private int wrestlerId;
	private double weight;
	private int lotNb;
	private Timestamp date;

	public String addWeighing() {
		try {
			Weighing weighing = new Weighing();
			weighing.setId(getId());
			weighing.setTourId(getTourId());
			weighing.setWrestlerId(getWrestlerId());
			weighing.setWeight(getWeight());
			weighing.setLotNb(getLotNb());
			weighing.setDate(getDate());
			clear();
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void reset() {
	}

	public List<Weighing> getWeighingList() {
		weighingList = new ArrayList<Weighing>();
		weighingList.addAll(getWeighingBO().getAllWeighings());
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

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public int getWrestlerId() {
		return wrestlerId;
	}

	public void setWrestlerId(int wrestlerId) {
		this.wrestlerId = wrestlerId;
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

	public void clear() {

	}

}
