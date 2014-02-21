package fr.lutarony.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import fr.lutarony.dao.definition.DAO;
import fr.lutarony.model.Weighing;
import fr.lutarony.util.CategoryType;

public class WeighingDAO extends DAO<Weighing> {

	public WeighingDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public WeighingDAO() {
		super();
	}

	@Override
	public boolean create(Weighing obj) {
		try {
			getSessionFactory().getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(Weighing obj) {
		try {
			getSessionFactory().getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Weighing obj) {
		try {
			getSessionFactory().getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Weighing find(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Weighing where id=?").setParameter(0, id)
				.list();
		return (Weighing) list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Weighing> getAll() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Weighing.class);
		criteria.setFetchMode("tournament", FetchMode.JOIN);
		criteria.setFetchMode("wrestler", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return (List<Weighing>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Weighing> getAllOrderBySurname() {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Weighing.class);
		criteria.setFetchMode("tournament", FetchMode.JOIN);
		criteria.setFetchMode("wrestler", FetchMode.JOIN);
		criteria.createAlias("wrestler", "w");
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("w.surname"));

		return (List<Weighing>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Weighing> getWeighingByCategory(CategoryType category) {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Weighing.class);
		criteria.createAlias("wrestler", "w").add(
				Restrictions.eq("w.category", category));
		return (List<Weighing>) criteria.list();
	}

}