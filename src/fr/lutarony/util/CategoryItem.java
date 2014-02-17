package fr.lutarony.util;

import fr.lutarony.model.Team;
import fr.lutarony.model.Weighing;
import fr.lutarony.model.Wrestler;

public class CategoryItem {
	private Weighing weighing;
	private Wrestler wrestler;
	private Team team;
	
	public CategoryItem(Weighing weighing, Wrestler wrestler, Team team) {
		super();
		this.weighing = weighing;
		this.wrestler = wrestler;
		this.team = team;
	}
	public Weighing getWeighing() {
		return weighing;
	}
	public void setWeighing(Weighing weighing) {
		this.weighing = weighing;
	}
	public Wrestler getWrestler() {
		return wrestler;
	}
	public void setWrestler(Wrestler wrestler) {
		this.wrestler = wrestler;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	

}
