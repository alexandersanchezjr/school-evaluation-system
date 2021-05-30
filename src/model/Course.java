package model;

import java.io.IOException;
import java.util.ArrayList;

public class Course {

	private String courseName;
	private ArrayList<Student> students;
	private ArrayList<Evaluation> evaluations;
	
	private Course next;
	
	public Course(String cn) {
		courseName = cn;
		students = new ArrayList<Student>();
		evaluations = new ArrayList<Evaluation>();
	}

	/**
	 * @return the next
	 */
	public Course getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Course next) {
		this.next = next;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the students
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	/**
	 * @return the evaluations
	 */
	public ArrayList<Evaluation> getEvaluations() {
		return evaluations;
	}

	/**
	 * @param evaluations the evaluations to set
	 */
	public void setEvaluations(ArrayList<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	//MANAGAMENT STUDENTS
	
	//Add Student
	
	public boolean addStudent(String name, String lastName, String email, String code) throws IOException {
		boolean added = false;
		Student newStudent = new Student(name, lastName, email, code);
		if(!students.contains(newStudent)) {
			added = students.add(newStudent);
		}
		return added;
	}
	
	//Update Student info
	
	public void updateStudent(Student s, String name, String lastName, String email, String code) throws IOException {
		int index = students.indexOf(s);
		students.get(index).setName(name);
		students.get(index).setLastName(lastName);
		students.get(index).setEmail(email);
		students.get(index).setCode(code);
	}
	
	//Delete Student
	
	public boolean deleteStudent(Student s) throws IOException {
		boolean deleted = false;
		if(students.contains(s)) {
			deleted = students.remove(s);
		}
		return deleted;
	}
	
	//Search Student
	
	public Student searchStudent(String code) {
		Student studentSearched = null;
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getCode().equals(code)) {
				studentSearched = students.get(i);
			}
		}
		return studentSearched;
	}

}
