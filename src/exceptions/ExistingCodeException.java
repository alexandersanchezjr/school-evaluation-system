package exceptions;

public class ExistingCodeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
