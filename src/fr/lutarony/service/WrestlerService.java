package fr.lutarony.service;

import java.util.List;

import fr.lutarony.model.Wrestler;

public interface WrestlerService {

	public void addWrestler(Wrestler wrestler);

	public List<Wrestler> findAll();

}
