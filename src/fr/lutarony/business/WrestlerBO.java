package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.BO;
import fr.lutarony.dao.WrestlerDAO;
import fr.lutarony.model.Wrestler;

/**
 * 
 * Wrestler Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Transactional(readOnly = true)
public class WrestlerBO implements BO<Wrestler> {

	// WrestlerDAO is injected...
	WrestlerDAO wrestlerDAO;

	/**
	 * Add Wrestler
	 * 
	 * @param Wrestler
	 *            wrestler
	 */
	@Transactional(readOnly = false)
	@Override
	public void create(Wrestler wrestler) {
		getWrestlerDAO().create(wrestler);
	}

	/**
	 * Delete Wrestler
	 * 
	 * @param Wrestler
	 *            wrestler
	 */
	@Transactional(readOnly = false)
	@Override
	public void delete(Wrestler wrestler) {
		getWrestlerDAO().delete(wrestler);
	}

	/**
	 * Update Wrestler
	 * 
	 * @param Wrestler
	 *            wrestler
	 */
	@Transactional(readOnly = false)
	@Override
	public void update(Wrestler wrestler) {
		getWrestlerDAO().update(wrestler);
	}

	/**
	 * Get Wrestler
	 * 
	 * @param int Wrestler Id
	 */
	@Override
	public Wrestler find(int id) {
		return getWrestlerDAO().find(id);
	}

	/**
	 * Get Wrestler List
	 * 
	 */
	@Override
	public List<Wrestler> getAll() {
		return getWrestlerDAO().getAll();
	}

	/**
	 * Get Wrestler DAO
	 * 
	 * @return IWrestlerDAO - Wrestler DAO
	 */
	public WrestlerDAO getWrestlerDAO() {
		return wrestlerDAO;
	}

	/**
	 * Set Wrestler DAO
	 * 
	 * @param IWrestlerDAO
	 *            - Wrestler DAO
	 */
	public void setWrestlerDAO(WrestlerDAO wrestlerDAO) {
		this.wrestlerDAO = wrestlerDAO;
	}
}