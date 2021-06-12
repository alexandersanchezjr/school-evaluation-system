package exceptions;

@SuppressWarnings("serial")
public class ExistingCodeException extends Exception {

	private String code;
	
	public ExistingCodeException(String code) {
		super("El codigo " + code + "ya esta asociado a un estudiante existente.");
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
