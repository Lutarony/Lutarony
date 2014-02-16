package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Team;

public interface ITeamBO {
	public void createTeam(Team obj);

	public void updateTeam(Team obj);

	public void deleteTeam(Team obj);

	public Team findTeam(int id);

	public List<Team> getAllTeams();
}
