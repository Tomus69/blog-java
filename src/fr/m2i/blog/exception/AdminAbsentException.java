package fr.m2i.blog.exception;

public class AdminAbsentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminAbsentException() {
		super("Impossible d'enregistrer un événement sans Admin");
	}

}

