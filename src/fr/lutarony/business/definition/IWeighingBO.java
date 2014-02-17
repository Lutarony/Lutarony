package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Weighing;

public interface IWeighingBO {
	
	public void createWeighing(Weighing obj);

	public void updateWeighing(Weighing obj);

	public void deleteWeighing(Weighing obj);

	public Weighing findWeighing(int id);

	public List<Weighing> getAllWeighings();
}
