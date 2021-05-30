package model;

public class Teacher extends Member {

	private String password;
	private boolean fullTime; //If this boolean value is true it means this teacher is full time, else he's half time teacher.
	private String career;
	
	private Course firstCourse;
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

	/**
	 * @return the courses
	 */
	public Course getFirstCourse() {
		return firstCourse;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setFirstCourse(Course firstCourse) {
		this.firstCourse = firstCourse;
	}
	
	//MANAGEMENT COURSES
	
	//Add Course Recursively
	
	/**
	* Add a new course to the linked list of courses if the list is empty and the course to add is the first.<br>
	* <b>post:</b> Has been added a new course to the teacher profile if and only if the new course did not exist previously. 
	* @param name The name of the new course.
	*/
	public void addCourse(String name) {
		Course newCourse = new Course(name);
		if(firstCourse == null) {
			firstCourse = newCourse;
		}else {
			addCourse(firstCourse, newCourse);
		}
	}
	
	/**
	* Add a new teacher to the linked list of teachers recursively.<br>
	* <b>post:</b> Has been added a new teacher to the system if and only if the new teacher did not exist previously. 
	* @param newTeacher The new teacher to be added. current != null.
	* @param current The linked list teacher which will be traverse.
	*/
	private void addCourse(Course current, Course newTeacher) {
		if(current.getNext() == null) {
			current.setNext(newTeacher);
		}else {
			addCourse(current.getNext(), newTeacher);
		}
	}
	
	public void updateCourse(Course c) {
		
	}
	
	public void removeCourse(Course c) {
		
	}
}
