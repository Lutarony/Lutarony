package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.ITournamentBO;
import fr.lutarony.dao.TournamentDAO;
import fr.lutarony.model.Tournament;

@Transactional(readOnly = true)
public class TournamentBO implements ITournamentBO {

	// TournamentDAO is injected...
	TournamentDAO TournamentDAO;

	/**
	 * Add Tournament
	 * 
	 * @param Tournament
	 *            Tournament
	 */
	@Transactional(readOnly = false)
	@Override
	public void createTournament(Tournament Tournament) {
		getTournamentDAO().create(Tournament);
	}

	/**
	 * Delete Tournament
	 * 
	 * @param Tournament
	 *            Tournament
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteTournament(Tournament Tournament) {
		getTournamentDAO().delete(Tournament);
	}

	/**
	 * Update Tournament
	 * 
	 * @param Tournament
	 *            Tournament
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateTournament(Tournament Tournament) {
		getTournamentDAO().update(Tournament);
	}

	/**
	 * Get Tournament
	 * 
	 * @param int Tournament Id
	 */
	@Override
	public Tournament findTournament(int id) {
		return getTournamentDAO().find(id);
	}

	/**
	 * Get Tournament List
	 * 
	 */
	@Override
	public List<Tournament> getAllTournaments() {
		return getTournamentDAO().getAll();
	}

	/**
	 * Get Tournament DAO
	 * 
	 * @return ITournamentDAO - Tournament DAO
	 */
	public TournamentDAO getTournamentDAO() {
		return TournamentDAO;
	}

	/**
	 * Set Tournament DAO
	 * 
	 * @param ITournamentDAO
	 *            - Tournament DAO
	 */
	public void setTournamentDAO(TournamentDAO TournamentDAO) {
		this.TournamentDAO = TournamentDAO;
	}
}