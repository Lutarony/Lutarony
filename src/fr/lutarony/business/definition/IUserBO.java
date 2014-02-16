package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.User;

public interface IUserBO {
	public void createUser(User obj);

	public void updateUser(User obj);

	public void deleteUser(User obj);

	public User findUser(int id);

	public List<User> getAllUsers();
}
