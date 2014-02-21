package fr.lutarony.exceptions;

public class AlreadyExists extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7200848275728383264L;
	
	public AlreadyExists(String msg){
		super(msg);
	}

}
