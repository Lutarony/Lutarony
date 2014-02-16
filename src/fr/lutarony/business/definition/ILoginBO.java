package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Login;

public interface ILoginBO {
	public void createLogin(Login obj);

	public void updateLogin(Login obj);

	public void deleteLogin(Login obj);

	public Login findLogin(int id);

	public List<Login> getAllLogins();
}
