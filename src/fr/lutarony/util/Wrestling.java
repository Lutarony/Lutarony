package fr.lutarony.util;

public enum Wrestling {
	WOMEN, GRECO_ROMANE, FREE;

	private String value;

	private Wrestling() {

	}

	private Wrestling(String value) {
		this.value = value;
	}

	/** GETTERS AND SETTERS **/

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
