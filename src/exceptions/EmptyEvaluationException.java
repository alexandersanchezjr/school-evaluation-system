package exceptions;

public class EmptyEvaluationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyEvaluationException() {
		super("La evaluacion no tiene contenido");
	}

}
