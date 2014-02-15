package fr.lutarony.dao;

import java.util.List;

import fr.lutarony.model.Wrestler;

public interface IWrestlerDAO {
	
	public Wrestler getWrestlerById(int id);

	public void addWrestler(Wrestler wrestler);

	public void updateWrestler(Wrestler wrestler);

	public void deleteWrestler(Wrestler wrestler);

	public List<Wrestler> getWrestlers();

}