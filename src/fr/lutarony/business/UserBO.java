package fr.lutarony.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.business.definition.IUserBO;
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
@Component
@Transactional(readOnly = true)
public class UserBO implements IUserBO {

	// UserDAO is injected...
	@Autowired
	UserDAO userDAO;

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	@Override
	public void createUser(User user) {
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
	public void deleteUser(User user) {
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
	public void updateUser(User user) {
		getUserDAO().update(user);
	}

	/**
	 * Get User
	 * 
	 * @param int User Id
	 */
	@Override
	public User findUser(int id) {
		return getUserDAO().find(id);
	}

	/**
	 * Get User List
	 * 
	 */
	@Override
	public List<User> getAllUsers() {
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