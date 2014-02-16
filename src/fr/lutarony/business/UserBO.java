package fr.lutarony.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.BO;
import fr.lutarony.dao.UserDAO;
import fr.lutarony.model.User;

/**
 * 
 * User Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Transactional(readOnly = true)
public class UserBO implements BO<User> {

	// UserDAO is injected...
	UserDAO userDAO;

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	@Override
	public void create(User user) {
		getUserDAO().create(user);
	}

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	@Override
	public void delete(User user) {
		getUserDAO().delete(user);
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	@Override
	public void update(User user) {
		getUserDAO().update(user);
	}

	/**
	 * Get User
	 * 
	 * @param int User Id
	 */
	@Override
	public User find(int id) {
		return getUserDAO().find(id);
	}

	/**
	 * Get User List
	 * 
	 */
	@Override
	public List<User> getAll() {
		return getUserDAO().getAll();
	}

	/**
	 * Get User DAO
	 * 
	 * @return IUserDAO - User DAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 * 
	 * @param IUserDAO
	 *            - User DAO
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}