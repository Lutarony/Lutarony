package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Team;

public interface ITeamBO {

	public void addTeam(Team team);

	public void updateTeam(Team team);

	public void deleteTeam(Team team);

	public Team getTeamById(int id);

	public List<Team> getTeams();

}