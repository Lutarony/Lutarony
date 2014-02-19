package fr.lutarony.business.definition;

import java.util.List;

import fr.lutarony.model.Weighing;
import fr.lutarony.util.CategoryType;

public interface IWeighingBO {
	
	public void createWeighing(Weighing obj);

	public void updateWeighing(Weighing obj);

	public void deleteWeighing(Weighing obj);

	public Weighing findWeighing(int id);
	
	public List<Weighing> getWeighingsByCategory(CategoryType cat);
	
	public List<Weighing> getAllOrderBySurname();

	public List<Weighing> getAllWeighings();
}
