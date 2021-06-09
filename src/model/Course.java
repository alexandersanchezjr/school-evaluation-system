package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Course {

	private String courseName;
	private ArrayList<Student> students;
	private ArrayList<Activity> activities;
	private ArrayList<Exam> exams;
	private ArrayList<Grade> averageGrades;
	
	private Course next;
	
	public Course(String cn) {
		courseName = cn;
		students = new ArrayList<Student>();
		activities = new ArrayList<Activity>();
		exams = new ArrayList<Exam>();
		setAverageGrades(new ArrayList<Grade>());
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
	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public ArrayList<Questionnaire> getQuestionnaires () {
		ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
		for (Activity element : activities) {
			if (element instanceof Questionnaire) {
				questionnaires.add((Questionnaire) element);
			}
		}
		return questionnaires;
	}

	/**
	 * @param evaluations the evaluations to set
	 */
	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
	/**
	 * @return the exams
	 */
	public ArrayList<Exam> getExams() {
		return exams;
	}

	/**
	 * @param exams the exams to set
	 */
	public void setExams(ArrayList<Exam> exams) {
		this.exams = exams;
	}
	
	//MANAGAMENT STUDENTS
	
	//Add Student

	/**
	 * @return the averageGrades
	 */
	public ArrayList<Grade> getAverageGrades() {
		return averageGrades;
	}

	/**
	 * @param averageGrades the averageGrades to set
	 */
	public void setAverageGrades(ArrayList<Grade> averageGrades) {
		this.averageGrades = averageGrades;
	}

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
	
	//MANAGEMENT EVALUATIONS
	
	//Add Questionnaire
	
	public boolean addActivity(String topic, int percentage, String content, LocalDate date, int attempts) {
		boolean added = false;
		Activity newQuestionnaire = new Questionnaire(topic, percentage, content, date, attempts);
		if(!activities.contains(newQuestionnaire)) {
			added = activities.add(newQuestionnaire);
		}
		return added;
	}
	
	//Add WorkShop
	
	public boolean addActivity(String topic, int percentage, String content, LocalDate date, String answers) {
		boolean added = false;
		Activity newWorkshop = new Workshop(topic, percentage, content, date, answers);
		if(!activities.contains(newWorkshop)) {
			added = activities.add(newWorkshop);
		}
		return added;
	}
	
	//Add Exams
	
	public boolean addExam(String topic, int percentage, String content, int timeLimit) {
		boolean added = false;
		Exam newExam = new Exam(topic, percentage, content, timeLimit);	
		if(!exams.contains(newExam)) {
			added = exams.add(newExam);
		}
		return added;
	}
	
	//IMPORT STUDENTS
	
	public void importStudents(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line!=null ) {
			String[] parts = line.split(separator);
			String name = parts[0];
			String lastName = parts[1];
			String email = parts[2];
			String code = parts[3];
			double finalAverageGrade = Double.parseDouble(parts[4]);
			students.add(new Student(name, lastName, email, code, finalAverageGrade));
			line = br.readLine();
		}
		br.close();
	}
	
	//EXPORT STUDENTS
	
	public void exportStudents(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for(int j = 0; j < students.size(); j++){
    		pw.write(students.get(j).getName() + separator + students.get(j).getLastName() + separator + students.get(j).getEmail() + separator + students.get(j).getCode() + separator + students.get(j).getFinalAverageGrade()); 
    	}
		pw.close();
	}
	
	//IMPORT ACTIVITIES
	
	public void importWorkshops(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line!=null ) {
			String[] parts = line.split(separator);
			String topic = parts[0];
			int percentage = Integer.parseInt(parts[1]);
			String content = parts[2];
			CharSequence cs = parts[3].subSequence(0, parts[3].length());
			LocalDate date = LocalDate.parse(cs);
			//TODO import the list of helpLinks
			String answers = parts[4];
			activities.add(new Workshop(topic, percentage, content, date, answers));
			line = br.readLine();
		}
		br.close();
	}
	
	//EXPORT ACTIVITIES
	
	public void exportActivities(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for(int j = 0; j < activities.size(); j++){
    		if(activities.get(j) instanceof Workshop) {
    			Workshop ws = (Workshop) activities.get(j);
    			//TODO export the list of helpLinks
    			pw.write(ws.getTopic() + separator + ws.getPercentage() + separator + ws.getContent() + separator + ws.getAssignmentDate() + separator + ws.getAnswers()); 
    		}else if(activities.get(j) instanceof Questionnaire) {
    			Questionnaire quest = (Questionnaire) activities.get(j);
    			//TODO export the list of helpLinks
    			pw.write(quest.getTopic() + separator + quest.getPercentage() + separator + quest.getContent() + separator + quest.getAssignmentDate() + separator + quest.getAttempts());
    		}
		}
		pw.close();
	}
		
	
	@Override
	public String toString() {
		return courseName;
	}

}
