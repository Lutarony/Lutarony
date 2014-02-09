package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.User;

public interface IUserBO {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUserById(int id);

	public List<User> getUsers();

}