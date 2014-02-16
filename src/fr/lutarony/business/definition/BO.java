package fr.lutarony.business.definition;

import java.util.List;

public interface BO<T> {

	public void create(T obj);

	public void update(T obj);

	public void delete(T obj);

	public T find(int id);

	public List<T> getAll();
}
