package model;

public class Teacher extends Member {

	private boolean fullTime; //If this boolean value is true it means this teacher is full time, else he's half time teacher.
	
	public Teacher(String name, String lastName, String email, String code, boolean fullTime) {
		super(name, lastName, email, code);
		this.fullTime = fullTime;
	}

	/**
	 * @return the fullTime
	 */
	public boolean isFullTime() {
		return fullTime;
	}

	/**
	 * @param fullTime the fullTime to set
	 */
	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

}
