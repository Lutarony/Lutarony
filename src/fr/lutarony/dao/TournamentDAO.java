package fr.lutarony.dao;

import java.util.List;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Tournament;

public class TournamentDAO extends DAO<Tournament> {

	@Override
	public boolean create(Tournament obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(Tournament obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Tournament obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Tournament find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Tournament where id=?").setParameter(0, id)
				.list();
		return (Tournament) list.get(0);
	}

	@Override
	public List<Tournament> getAll() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Tournament").list();
		return list;
	}

}