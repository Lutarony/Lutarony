package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.IWrestlerBO;
import fr.lutarony.dao.IWrestlerDAO;
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
public class WrestlerBO implements IWrestlerBO {

	// WrestlerDAO is injected...
	IWrestlerDAO wrestlerDAO;

	/**
	 * Add Wrestler
	 * 
	 * @param Wrestler
	 *            wrestler
	 */
	@Transactional(readOnly = false)
	@Override
	public void addWrestler(Wrestler wrestler) {
		getWrestlerDAO().addWrestler(wrestler);
	}

	/**
	 * Delete Wrestler
	 * 
	 * @param Wrestler
	 *            wrestler
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteWrestler(Wrestler wrestler) {
		getWrestlerDAO().deleteWrestler(wrestler);
	}

	/**
	 * Update Wrestler
	 * 
	 * @param Wrestler
	 *            wrestler
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateWrestler(Wrestler wrestler) {
		getWrestlerDAO().updateWrestler(wrestler);
	}

	/**
	 * Get Wrestler
	 * 
	 * @param int Wrestler Id
	 */
	@Override
	public Wrestler getWrestlerById(int id) {
		return getWrestlerDAO().getWrestlerById(id);
	}

	/**
	 * Get Wrestler List
	 * 
	 */
	@Override
	public List<Wrestler> getWrestlers() {
		return getWrestlerDAO().getWrestlers();
	}

	/**
	 * Get Wrestler DAO
	 * 
	 * @return IWrestlerDAO - Wrestler DAO
	 */
	public IWrestlerDAO getWrestlerDAO() {
		return wrestlerDAO;
	}

	/**
	 * Set Wrestler DAO
	 * 
	 * @param IWrestlerDAO
	 *            - Wrestler DAO
	 */
	public void setWrestlerDAO(IWrestlerDAO wrestlerDAO) {
		this.wrestlerDAO = wrestlerDAO;
	}
}