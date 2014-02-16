package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Wrestler;

public interface IWrestlerBO {
	public void createWrestler(Wrestler obj);

	public void updateWrestler(Wrestler obj);

	public void deleteWrestler(Wrestler obj);

	public Wrestler findWrestler(int id);

	public List<Wrestler> getAllWrestlers();
}
