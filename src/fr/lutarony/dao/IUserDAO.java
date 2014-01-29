package fr.lutarony.dao;

import java.util.List;

import fr.lutarony.model.User;

public interface IUserDAO {
	
	public User getUserById(int id);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> getUsers();

}