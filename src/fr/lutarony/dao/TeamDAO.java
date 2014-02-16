package fr.lutarony.dao;

import java.util.List;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Team;

public class TeamDAO extends DAO<Team> {

	@Override
	public boolean create(Team obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(Team obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Team obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Team find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Team where id=?").setParameter(0, id).list();
		return (Team) list.get(0);
	}

	@Override
	public List<Team> getAll() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Team").list();
		return list;
	}

}