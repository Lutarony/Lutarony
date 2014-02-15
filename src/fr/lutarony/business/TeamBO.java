package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.ITeamBO;
import fr.lutarony.dao.ITeamDAO;
import fr.lutarony.model.Team;

/**
 * 
 * Team Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Transactional(readOnly = true)
public class TeamBO implements ITeamBO {

	// TeamDAO is injected...
	ITeamDAO teamDAO;

	/**
	 * Add Team
	 * 
	 * @param Team
	 *            team
	 */
	@Transactional(readOnly = false)
	@Override
	public void addTeam(Team team) {
		getTeamDAO().addTeam(team);
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
		getTeamDAO().deleteTeam(team);
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
		getTeamDAO().updateTeam(team);
	}

	/**
	 * Get Team
	 * 
	 * @param int Team Id
	 */
	@Override
	public Team getTeamById(int id) {
		return getTeamDAO().getTeamById(id);
	}

	/**
	 * Get Team List
	 * 
	 */
	@Override
	public List<Team> getTeams() {
		return getTeamDAO().getTeams();
	}

	/**
	 * Get Team DAO
	 * 
	 * @return ITeamDAO - Team DAO
	 */
	public ITeamDAO getTeamDAO() {
		return teamDAO;
	}

	/**
	 * Set Team DAO
	 * 
	 * @param ITeamDAO
	 *            - Team DAO
	 */
	public void setTeamDAO(ITeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}
}