package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.ILoginBO;
import fr.lutarony.dao.LoginDAO;
import fr.lutarony.model.Login;

@Transactional(readOnly = true)
public class LoginBO implements ILoginBO {

	// LoginDAO is injected...
	LoginDAO loginDAO;

	/**
	 * Add Login
	 * 
	 * @param Login
	 *            login
	 */
	@Transactional(readOnly = false)
	@Override
	public void createLogin(Login login) {
		getLoginDAO().create(login);
	}

	/**
	 * Delete Login
	 * 
	 * @param Login
	 *            login
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteLogin(Login login) {
		getLoginDAO().delete(login);
	}

	/**
	 * Update Login
	 * 
	 * @param Login
	 *            login
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateLogin(Login login) {
		getLoginDAO().update(login);
	}

	/**
	 * Get Login
	 * 
	 * @param int Login Id
	 */
	@Override
	public Login findLogin(int id) {
		return getLoginDAO().find(id);
	}

	/**
	 * Get Login List
	 * 
	 */
	@Override
	public List<Login> getAllLogins() {
		return getLoginDAO().getAll();
	}

	/**
	 * Get Login DAO
	 * 
	 * @return ILoginDAO - Login DAO
	 */
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	/**
	 * Set Login DAO
	 * 
	 * @param ILoginBO
	 *            - Login DAO
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
}