package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Wrestler;

public interface IWrestlerBO {

	public void addWrestler(Wrestler wrestler);

	public void updateWrestler(Wrestler wrestler);

	public void deleteWrestler(Wrestler wrestler);

	public Wrestler getWrestlerById(int id);

	public List<Wrestler> getWrestlers();

}