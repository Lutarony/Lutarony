package fr.lutarony.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import fr.lutarony.model.Wrestler;
import fr.lutarony.service.WrestlerService;

@ManagedBean(name="wrestlerBean")
@Scope
public class WrestlerBean {

	@Autowired
	private WrestlerService wrestlerService;
	
	private List<Wrestler> wrestlersList;

	public List<Wrestler> getWrestlersList() {
		wrestlersList = wrestlerService.findAll();
		return wrestlersList;
	}

	public void setWrestlersList(List<Wrestler> wrestlersList) {
		this.wrestlersList = wrestlersList;
	}
	
	public void saveWrestler(Wrestler wrestler){
		wrestlerService.addWrestler(wrestler);
	}
	
	
}
