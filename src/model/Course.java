package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public ArrayList<Workshop> getAssessments () {
		ArrayList<Workshop> assessments = new ArrayList<Workshop>();
		for (Activity element : activities) {
			if (element instanceof Workshop) {
				assessments.add((Workshop) element);
			}
		}
		return assessments;
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
	
	public Student binarySearchStudent(String name, String code) {
		Comparator<Student> nameAndCode = new Comparator<Student>() {
			@Override
            public int compare(Student obj1, Student obj2) {
                String f1 = obj1.getName().toLowerCase();
                String c1 = obj1.getCode().toLowerCase();
                String f2 = obj2.getName().toLowerCase();
                String c2 = obj2.getCode().toLowerCase();

                if (c1.compareTo(c2) == 0) {
                    return f2.compareTo(f1);
                } else {
                    return c2.compareTo(c1);
                }
            }
        };

        Student key = new Student(name, "", "", code);
        int index = Collections.binarySearch(students, key, nameAndCode);
        if (index < 0){
            key = null;
        }else {
            key = students.get(index);
        }
        return key;
    }
	
	//MANAGEMENT EVALUATIONS
	
	//Add Questionnaire
	
	public boolean addQuestionnaire(String topic, int percentage, String content, LocalDate date, int attempts) {
		boolean added = false;
		Activity newQuestionnaire = new Questionnaire(topic, percentage, content, date, attempts);
		if(!activities.contains(newQuestionnaire)) {
			added = activities.add(newQuestionnaire);
		}
		return added;
	}
	
	public boolean addQuestionnaire(String topic, int percentage, String content, LocalDate date, int attempts, ArrayList<String> helpLinks) {
		boolean added = false;
		Activity newQuestionnaire = new Questionnaire(topic, percentage, content, date, attempts, helpLinks);
		if(!activities.contains(newQuestionnaire)) {
			added = activities.add(newQuestionnaire);
		}
		return added;
	}

	public void cleanQuestionnaire () {
		for (Activity element : activities) {
			if (element instanceof Questionnaire){
				activities.remove(element);
			}
		}
	}
	
	//Modify Questionnaire
	
	public void updateQuestionnaire(Questionnaire q, String topic, int percentage, String content, LocalDate date, int attempts, ArrayList<String> helpLinks) {
		int index = activities.indexOf(q);
		activities.get(index).setTopic(topic);
		activities.get(index).setPercentage(percentage);
		activities.get(index).setContent(content);
		activities.get(index).setAssignmentDate(date);
		((Questionnaire) activities.get(index)).setAttempts(attempts);
		activities.get(index).setHelpLinks(helpLinks);
	}
	
	//Delete Questionnaire
	
	public boolean deleteQuestionnaire(Questionnaire q) {
		boolean deleted = false;
		if(activities.contains(q)) {
			deleted = activities.remove(q);
		}
		return deleted;
	}
	
	//Add WorkShop
	
	public boolean addWorkshop(String topic, int percentage, String content, LocalDate date, String answers) {
		boolean added = false;
		Activity newWorkshop = new Workshop(topic, percentage, content, date, answers);
		if(!activities.contains(newWorkshop)) {
			added = activities.add(newWorkshop);
		}
		return added;
	}
	
	public boolean addWorkshop(String topic, int percentage, String content, LocalDate date, String answers, ArrayList<String> helpLinks) {
		boolean added = false;
		Activity newWorkshop = new Workshop(topic, percentage, content, date, answers, helpLinks);
		if(!activities.contains(newWorkshop)) {
			added = activities.add(newWorkshop);
		}
		return added;
	}

	public void cleanAssessments () {
		for (Activity element : activities) {
			if (element instanceof Workshop){
				activities.remove(element);
			}
		}
	}
	
	//Modify WorkShop
	
	public void updateWorkshops(Workshop w, String topic, int percentage, String content, LocalDate date, String answers, ArrayList<String> helpLinks) {
		int index = activities.indexOf(w);
		activities.get(index).setTopic(topic);
		activities.get(index).setPercentage(percentage);
		activities.get(index).setContent(content);
		activities.get(index).setAssignmentDate(date);
		((Workshop) activities.get(index)).setAnswers(answers);
		activities.get(index).setHelpLinks(helpLinks);
	}
	
	//Delete WorkShop
	
	public boolean deleteWorkshop (Workshop w) {
		boolean deleted = false;
		if(activities.contains(w)) {
			deleted = activities.remove(w);
		}
		return deleted;
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
	
	//Modify Exam
	
	public void updateExam(Exam e, String topic, int percentage, String content, int timeLimit) {
		int index = exams.indexOf(e);
		exams.get(index).setTopic(topic);
		exams.get(index).setPercentage(percentage);
		exams.get(index).setContent(content);
		exams.get(index).setTimeLimit(timeLimit);
	}
	
	//Delete Exam
	
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
		while (line != null ) {
			String[] parts = line.split(separator);
			String topic = parts[0];
			int percentage = Integer.parseInt(parts[1]);
			String content = parts[2];
			CharSequence cs = parts[3].subSequence(0, parts[3].length());
			LocalDate date = LocalDate.parse(cs);
			//TODO import the list of helpLinks
			String answers = parts[4];
			ArrayList<String> helpLinks = new ArrayList<>();
			for(int i = 5; i < parts.length; i++) {
				helpLinks.add(parts[i]);
			}
			addWorkshop(topic, percentage, content, date, answers, helpLinks);
			line = br.readLine();
		}
		br.close();
	}
	
	public void importQuestionnaires(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line!=null ) {
			String[] parts = line.split(separator);
			String topic = parts[0];
			int percentage = Integer.parseInt(parts[1]);
			String content = parts[2];
			CharSequence cs = parts[3].subSequence(0, parts[3].length());
			LocalDate date = LocalDate.parse(cs);
			int attempts = Integer.parseInt(parts[4]);
			ArrayList<String> helpLinks = new ArrayList<>();
			for(int i = 5; i < parts.length; i++) {
				helpLinks.add(parts[i]);
			}
			addQuestionnaire(topic, percentage, content, date, attempts, helpLinks);
			line = br.readLine();
		}
		br.close();
	}
	
	//EXPORT ACTIVITIES
	
	public void exportWorkshops(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for(int i = 0; i < activities.size(); i++){
    		if(activities.get(i) instanceof Workshop) {
    			Workshop ws = (Workshop) activities.get(i);
    			String helpLinks = "";
    			for(int j = 0; j < ws.getHelpLinks().size(); j++) {
    				helpLinks += separator + ws.getHelpLinks().get(i);
    			}
    			pw.write(ws.getTopic() + separator + ws.getPercentage() + separator + ws.getContent() + separator + ws.getAssignmentDate() + separator + ws.getAnswers() + helpLinks); 
		
    		}
		}
		pw.close();
	}
	
	public void exportQuestionnaires(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for(int i = 0; i < activities.size(); i++){
			if(activities.get(i) instanceof Questionnaire) {
    			Questionnaire quest = (Questionnaire) activities.get(i);
    			String helpLinks = "";
    			for(int j = 0; j < quest.getHelpLinks().size(); j++) {
    				helpLinks += separator + quest.getHelpLinks().get(i);
    			}
    			pw.write(quest.getTopic() + separator + quest.getPercentage() + separator + quest.getContent() + separator + quest.getAssignmentDate() + separator + quest.getAttempts() + helpLinks);
    		}
		}
		pw.close();
	}
		
	//IMPORT EXAMS
	
	public void importExams(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line!=null ) {
			String[] parts = line.split(separator);
			String topic = parts[0];
			int percentage = Integer.parseInt(parts[1]);
			String content = parts[2];
			//TODO import the list of helpLinks
			int timeLimit = Integer.parseInt(parts[4]);
			addExam(topic, percentage, content, timeLimit);
			line = br.readLine();
		}
		br.close();
	}
	
	//EXPORT EXAMS
	
	public void exportExams(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for(int j = 0; j < exams.size(); j++){
			pw.write(exams.get(j).getTopic() + separator + exams.get(j).getPercentage() + separator + exams.get(j).getContent() + separator + exams.get(j).getTimeLimit()); 
		}
		pw.close();
	}
	
	@Override
	public String toString() {
		return courseName;
	}

}
