package fr.lutarony.util;

public enum CategoryType {
	POUSSIN, MINIME, BENJAMIN, CADET, JUNIOR, SENIOR, NONE;

	public static boolean isCategory(String cat) {
		return cat.toUpperCase().equals(POUSSIN.toString())
				|| cat.toUpperCase().equals(MINIME.toString())
				|| cat.toUpperCase().equals(BENJAMIN.toString())
				|| cat.toUpperCase().equals(CADET.toString())
				|| cat.toUpperCase().equals(JUNIOR.toString())
				|| cat.toUpperCase().equals(SENIOR.toString());
	}
}
