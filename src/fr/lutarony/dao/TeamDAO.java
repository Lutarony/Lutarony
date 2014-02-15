package fr.lutarony.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.lutarony.model.Team;

public class TeamDAO implements ITeamDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTeam(Team team) {
		getSessionFactory().getCurrentSession().save(team);
	}

	@Override
	public void deleteTeam(Team team) {
		getSessionFactory().getCurrentSession().delete(team);
	}

	@Override
	public void updateTeam(Team team) {
		getSessionFactory().getCurrentSession().update(team);
	}

	@Override
	public Team getTeamById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Team where id=?").setParameter(0, id).list();
		return (Team) list.get(0);
	}

	@Override
	public List<Team> getTeams() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Team").list();
		return list;
	}

}