package exceptions;

public class OutOfDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfDateException() {
		super("La fecha de inicio ingresada ha caducado");
	}

}
