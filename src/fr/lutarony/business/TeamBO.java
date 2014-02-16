package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.BO;
import fr.lutarony.dao.TeamDAO;
import fr.lutarony.model.Team;

@Transactional(readOnly = true)
public class TeamBO implements BO<Team> {

	// TeamDAO is injected...
	TeamDAO teamDAO;

	/**
	 * Add Team
	 * 
	 * @param Team
	 *            team
	 */
	@Transactional(readOnly = false)
	@Override
	public void create(Team team) {
		getTeamDAO().create(team);
	}

	/**
	 * Delete Team
	 * 
	 * @param Team
	 *            team
	 */
	@Transactional(readOnly = false)
	@Override
	public void delete(Team team) {
		getTeamDAO().delete(team);
	}

	/**
	 * Update Team
	 * 
	 * @param Team
	 *            team
	 */
	@Transactional(readOnly = false)
	@Override
	public void update(Team team) {
		getTeamDAO().update(team);
	}

	/**
	 * Get Team
	 * 
	 * @param int Team Id
	 */
	@Override
	public Team find(int id) {
		return getTeamDAO().find(id);
	}

	/**
	 * Get Team List
	 * 
	 */
	@Override
	public List<Team> getAll() {
		return getTeamDAO().getAll();
	}

	/**
	 * Get Team DAO
	 * 
	 * @return ITeamDAO - Team DAO
	 */
	public TeamDAO getTeamDAO() {
		return teamDAO;
	}

	/**
	 * Set Team DAO
	 * 
	 * @param ITeamDAO
	 *            - Team DAO
	 */
	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}
}