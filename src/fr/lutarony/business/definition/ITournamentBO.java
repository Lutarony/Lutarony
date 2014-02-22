package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Tournament;

public interface ITournamentBO {
	public void createTournament(Tournament obj);

	public void updateTournament(Tournament obj);

	public void deleteTournament(Tournament obj);

	public Tournament findTournament(int id);

	public List<Tournament> getAllTournaments();
}
