package fr.lutarony.dao;

import java.util.List;

import fr.lutarony.model.Team;

public interface ITeamDAO {
	
	public Team getTeamById(int id);

	public void addTeam(Team team);

	public void updateTeam(Team team);

	public void deleteTeam(Team team);

	public List<Team> getTeams();

}