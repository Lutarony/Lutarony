package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.ITeamBO;
import fr.lutarony.dao.TeamDAO;
import fr.lutarony.model.Team;
import fr.lutarony.model.Wrestler;

@Transactional(readOnly = true)
public class TeamBO implements ITeamBO {

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
	public void createTeam(Team team) {
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
	public void deleteTeam(Team team) {
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
	public void updateTeam(Team team) {
		getTeamDAO().update(team);
	}

	/**
	 * Get Team
	 * 
	 * @param int Team Id
	 */
	@Override
	public Team findTeam(int id) {
		return getTeamDAO().find(id);
	}

	/**
	 * Get Team List
	 * 
	 */
	@Override
	public List<Team> getAllTeams() {
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
	
	@Override
	public List<Team> getAllOrderByName() {
		return teamDAO.getAllOrderBySurname();
	}
	
}