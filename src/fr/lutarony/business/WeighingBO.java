package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.IWeighingBO;
import fr.lutarony.dao.WeighingDAO;
import fr.lutarony.model.Weighing;

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

	/**
	 * Add Weighing
	 * 
	 * @param Weighing
	 *            Weighing
	 */
	@Transactional(readOnly = false)
	@Override
	public void createWeighing(Weighing Weighing) {
		getWeighingDAO().create(Weighing);
	}

	/**
	 * Delete Weighing
	 * 
	 * @param Weighing
	 *            Weighing
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteWeighing(Weighing Weighing) {
		getWeighingDAO().delete(Weighing);
	}

	/**
	 * Update Weighing
	 * 
	 * @param Weighing
	 *            Weighing
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateWeighing(Weighing Weighing) {
		getWeighingDAO().update(Weighing);
	}

	/**
	 * Get Weighing
	 * 
	 * @param int Weighing Id
	 */
	@Override
	public Weighing findWeighing(int id) {
		return getWeighingDAO().find(id);
	}

	/**
	 * Get Weighing List
	 * 
	 */
	@Override
	public List<Weighing> getAllWeighings() {
		return getWeighingDAO().getAll();
	}

	/**
	 * Get Weighing DAO
	 * 
	 * @return IWeighingDAO - Weighing DAO
	 */
	public WeighingDAO getWeighingDAO() {
		return weighingDAO;
	}

	/**
	 * Set Weighing DAO
	 * 
	 * @param IWeighingDAO
	 *            - Weighing DAO
	 */
	public void setWeighingDAO(WeighingDAO WeighingDAO) {
		this.weighingDAO = WeighingDAO;
	}
	
}