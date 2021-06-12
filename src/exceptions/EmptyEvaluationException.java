package exceptions;

@SuppressWarnings("serial")
public class EmptyEvaluationException extends Exception {

	public EmptyEvaluationException() {
		super("La evaluacion no tiene contenido");
	}

}
