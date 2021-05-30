package model;

public class Teacher extends Member {

	private String password;
	private boolean fullTime; //If this boolean value is true it means this teacher is full time, else he's half time teacher.
	private String career;
	
	private Teacher next;
	
	public Teacher(String name, String lastName, String email, String code, String password, boolean fullTime) {
		super(name, lastName, email, code);
		this.password = password;
		this.fullTime = fullTime;
	}

	/**
	 * @return the next Teacher
	 */
	public Teacher getNext() {
		return next;
	}

	/**
	 * @param next set the next Teacher
	 */
	public void setNext(Teacher next) {
		this.next = next;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @return the career
	 */
	public String getCareer() {
		return career;
	}

	/**
	 * @param career the career to set
	 */
	public void setCareer(String career) {
		this.career = career;
	}

}
