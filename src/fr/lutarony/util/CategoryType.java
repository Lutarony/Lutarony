package fr.lutarony.util;

import java.util.Arrays;
import java.util.List;

public enum CategoryType {

	// can be set from XML file

	POUSSIN(2005, 2006, Arrays.asList(12, 14, 16, 17, 18, 20, 22, 26, 28, 30,
			32, 34, 36, 38, 40, 42, 44, 46, 48, 50)),
	// POUSSIN_C(2003, 2004,
	// Arrays.asList(17,20,22,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,57,60)),

	BENJAMIN(2001, 2002, Arrays.asList(24, 27, 30, 33, 36, 40, 44, 49, 54, 60,
			66, 73, 81)),

	MINIME(1999, 2000, Arrays.asList(35, 38, 42, 46, 50, 55, 60, 66, 72, 85)),
	// MINIME_F(1999, 2000, Arrays.asList(37,40,43,46,50,54,58,63,69)),

	CADET(1997, 1998, Arrays.asList(42, 46, 50, 54, 58, 63, 69, 76, 85, 100), 1),
	// CADET_F(1997, 1998, Arrays.asList(38,40,43,46,49,52,56,60,65,70), 1),

	JUNIOR(1994, 1996, Arrays.asList(50, 55, 60, 66, 74, 84, 96, 120), 2),
	// JUNIOR_F(1994, 1996, Arrays.asList(44,48,51,59,63,67,72), 2),

	SENIOR(1978, 1993, Arrays.asList(55, 60, 66, 74, 84, 96, 120), 2),
	// SENIOR_F(1978, 1993, Arrays.asList(48,51,55,59,63,67,72), 2),

	NONE();

	private int maxYear;
	private int minYear;
	private List<Integer> weightList; // en KG
	private int tolerance = 0; // en KG

	public static int getTolerance(CategoryType cat) {

		if (cat.equals(POUSSIN)) {
			return POUSSIN.getTolerance();
		}
		if (cat.equals(BENJAMIN)) {
			return BENJAMIN.getTolerance();
		}

		if (cat.equals(MINIME)) {
			return MINIME.getTolerance();
		}
		if (cat.equals(CADET)) {
			return CADET.getTolerance();
		}
		if (cat.equals(JUNIOR)) {
			return JUNIOR.getTolerance();
		}
		if (cat.equals(SENIOR)) {
			return SENIOR.getTolerance();
		}
		return 0;

	}

	/** CONSTRUCTORS **/

	private CategoryType() {

	}

	private CategoryType(int maxYear, int minYear,
			List<Integer> weightCategories) {
		this.maxYear = maxYear;
		this.minYear = minYear;
		this.weightList = weightCategories;
	}

	private CategoryType(int maxYear, int minYear,
			List<Integer> weightCategories, int tolerance) {
		this(minYear, maxYear, weightCategories);
		this.tolerance = tolerance;
	}

	/** GETTERS AND SETTERS **/

	public int getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(int maxYear) {
		this.maxYear = maxYear;
	}

	public int getMinYear() {
		return minYear;
	}

	public void setMinYear(int minYear) {
		this.minYear = minYear;
	}

	public List<Integer> getWeightList() {
		return weightList;
	}

	public void setWeightList(List<Integer> weightList) {
		this.weightList = weightList;
	}

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}

	public static boolean isCategory(String cat) {
		return cat.toUpperCase().equals(POUSSIN.toString())
				// || cat.toUpperCase().equals(POUSSIN_C.toString())
				|| cat.toUpperCase().equals(MINIME.toString())
				// || cat.toUpperCase().equals(MINIME_F.toString())
				|| cat.toUpperCase().equals(BENJAMIN.toString())
				|| cat.toUpperCase().equals(CADET.toString())
				// || cat.toUpperCase().equals(CADET_F.toString())
				|| cat.toUpperCase().equals(JUNIOR.toString())
				// || cat.toUpperCase().equals(JUNIOR_F.toString())
				|| cat.toUpperCase().equals(SENIOR.toString());
		// || cat.toUpperCase().equals(SENIOR_F.toString());
	}
}
