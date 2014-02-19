package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.IWeighingBO;
import fr.lutarony.dao.WeighingDAO;
import fr.lutarony.model.Weighing;
import fr.lutarony.util.CategoryType;

/**
 * 
 * Weighing Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Transactional(readOnly = true)
public class WeighingBO implements IWeighingBO {

	// WeighingDAO is injected...
	WeighingDAO weighingDAO;


	@Transactional(readOnly = false)
	@Override
	public void createWeighing(Weighing Weighing) {
		getWeighingDAO().create(Weighing);
	}


	@Transactional(readOnly = false)
	@Override
	public void deleteWeighing(Weighing Weighing) {
		getWeighingDAO().delete(Weighing);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateWeighing(Weighing Weighing) {
		getWeighingDAO().update(Weighing);
	}

	@Override
	public Weighing findWeighing(int id) {
		return getWeighingDAO().find(id);
	}

	@Override
	public List<Weighing> getAllWeighings() {
		return getWeighingDAO().getAll();
	}

	@Override
	public List<Weighing> getWeighingsByCategory(CategoryType cat) {
		return getWeighingDAO().getWeighingByCategory(cat);
	}


	public WeighingDAO getWeighingDAO() {
		return weighingDAO;
	}

	public void setWeighingDAO(WeighingDAO WeighingDAO) {
		this.weighingDAO = WeighingDAO;
	}

}