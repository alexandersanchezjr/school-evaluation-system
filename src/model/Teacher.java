package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Teacher extends Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private boolean fullTime; //If this boolean value is true it means this teacher is full time, else he's half time teacher.
	private String career;
	private int contEvaluations;
	
	private Course firstCourse;
	private Teacher next;
	
	public Teacher(String name, String lastName, String email, String code, String password, boolean fullTime, String career, int cont) {
		super(name, lastName, email, code);
		this.password = password;
		this.fullTime = fullTime;
		this.career = career;
		contEvaluations = cont;
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
	 * @return the contEvaluations
	 */
	public int getContEvaluations() {
		return contEvaluations;
	}

	/**
	 * @param contEvaluations the contEvaluations to set
	 */
	public void setContEvaluations(int contEvaluations) {
		this.contEvaluations = contEvaluations;
	}

	/**
	 * @return the courses
	 */
	public Course getFirstCourse() {
		return firstCourse;
	}

	public ArrayList<Course> getCourses () {
		ArrayList<Course> courses = new ArrayList<Course>();
		if (firstCourse != null) {
			courses.add(firstCourse);
			getCourses(firstCourse.getNext(), courses);
		}
		return courses;
	}

	private void getCourses (Course course, ArrayList<Course> courses) {
		if (course != null) {
			courses.add(course);
			getCourses(course.getNext(), courses);
		}
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
	
	//Update Course
	
	public void updateCourseName(Course c, String newName) {
		c.setCourseName(newName);
	}
	
	//Remove Course
	
	@SuppressWarnings("unused")
	public void removeCourse(Course c) {
		Course thisCourse = searchCourse(c.getCourseName());
		thisCourse = null;
	}
	
	
	//Search Course
	
	public Course searchCourse(String name) {
		Course courseSearched = null;
		if(firstCourse != null) {
			if(firstCourse.getCourseName().equals(name)) {
				courseSearched = firstCourse;
			}else {
				return searchCourse(name, firstCourse.getNext());
			}
		}else {
			return courseSearched;
		}
		return courseSearched;
	}
	
	private Course searchCourse(String name, Course current) {
		Course courseSearched = null;
		if(current != null) {
			if(current.getCourseName().equals(name)) {
				courseSearched = current;
			}else {
				courseSearched = searchCourse(name, current.getNext());
			}
		}
		return courseSearched;
	}
	
	public Course binarySearchCourse(String courseName) {
		Comparator<Course> name = new Comparator<Course>() {
			@Override
            public int compare(Course obj1, Course obj2) {
                String n1 = obj1.getCourseName().toLowerCase();
                String n2 = obj2.getCourseName().toLowerCase();

                return n2.compareTo(n1);
            }
        };

        Course key = new Course(courseName);
        int index = Collections.binarySearch(getCourses(), key, name);
        if (index < 0){
            key = null;
        }else {
            key = getCourses().get(index);
        }
        return key;
    }
}
