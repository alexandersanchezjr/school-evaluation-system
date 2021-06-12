package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class EvaluationSystem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public final String EVALUATION_SYSTEM_FILE_NAME = "data/evaluation-system.sys";

	//ATTRIBUTES
	
	Teacher firstTeacher;
	
	Teacher logged;
	/**
	 * 
	 */
	public EvaluationSystem() {
		firstTeacher = null;
	}
	/**
	 * @return the firstTeacher
	 */
	public Teacher getFirstTeacher() {
		return firstTeacher;
	}
	
	/**
	 * @param firstTeacher the firstTeacher to set
	 */
	public void setFirstTeacher(Teacher firstTeacher) {
		this.firstTeacher = firstTeacher;
	}
	
	/**
	 * @return the logged
	 */
	public Teacher getLogged() {
		return logged;
	}
	/**
	 * @param logged the logged to set
	 */
	public void setLogged(Teacher logged) {
		this.logged = logged;
	}
	
	//MANAGEMENT TEACHERS
	
	//Add Teacher Recursively
	
	/**
	* Add a new teacher to the linked list of teachers if the list is empty and the teacher to add is the first.<br>
	* <b>post:</b> Has been added a new teacher to the system if and only if the new teacher did not exist previously. 
	* @param name The name of the new teacher.
	* @param lastName The lastName of the new teacher.
	* @param email The e-mail of the new teacher.
	* @param code The institutional code assigned to the new teacher.
	* @param fullTime The type of the new teacher (boolean value, full time or half-time).
	 * @throws IOException 
	*/
	public void addTeacher(String name, String lastName, String email, String code, String password, boolean fullTime, String career, int contEvaluations) throws IOException {
		Teacher newTeacher = new Teacher(name, lastName, email, code, password, fullTime, career, contEvaluations);
		if(firstTeacher == null) {
			firstTeacher = newTeacher;
		}else {
			addTeacher(firstTeacher, newTeacher);
		}
	}
	
	/**
	* Add a new teacher to the linked list of teachers recursively.<br>
	* <b>post:</b> Has been added a new teacher to the system if and only if the new teacher did not exist previously. 
	* @param newTeacher The new teacher to be added. current != null.
	* @param current The linked list teacher which will be traverse.
	 * @throws IOException 
	*/
	private void addTeacher(Teacher current, Teacher newTeacher) throws IOException {
		if(current.getNext() == null) {
			current.setNext(newTeacher);
		}else {
			addTeacher(current.getNext(), newTeacher);
		}
	}
	
	//Update Teacher Info
	public void updateTeacher(String name, String lastName, String email, String code, String password, boolean fullTime) throws IOException {
		logged.setName(name);
		logged.setLastName(lastName);
		logged.setEmail(email);
		logged.setCode(code);
		logged.setPassword(password);
		logged.setFullTime(fullTime);
	}
	
	//Remove Logged Teacher
	
	@SuppressWarnings("unused")
	public void removeTeacher() throws IOException {
		Teacher thisTeacher = searchTeacher(logged.getCode());
		thisTeacher = null;
	}
	
	//Search Teacher
	
	public Teacher searchTeacher(String code) {
		Teacher teacherSearched = null;
		if(firstTeacher != null) {
			if(firstTeacher.getCode().equals(code)) {
				teacherSearched = firstTeacher;
			}else {
				return searchTeacher(code, firstTeacher.getNext());
			}
		}else {
			return teacherSearched;
		}
		return teacherSearched;
	}
	
	private Teacher searchTeacher(String code, Teacher current) {
		Teacher teacherSearched = null;
		if(current != null) {
			if(current.getCode().equals(code)) {
				teacherSearched = current;
			}else {
				teacherSearched = searchTeacher(code, current.getNext());
			}
		}
		return teacherSearched;
	}
	
	//IMPORT TEACHERS
	
	public void importTeachers(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line!=null ) {
			String[] parts = line.split(separator);
			String name = parts[0];
			String lastName = parts[1];
			String email = parts[2];
			String code = parts[3];
			String password = parts[4];
			boolean fullTime = Boolean.parseBoolean(parts[5]);
			String career = parts[6];
			int contEvaluations = Integer.parseInt(parts[7]);
			addTeacher(name, lastName, email, code, password, fullTime, career, contEvaluations);
			line = br.readLine();
		}
		br.close();
	}
	
	//EXPORT TEACHERS
	
	public void exportTeachers(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		Teacher current = firstTeacher;
		while(current != null) {
			pw.write(current.getName() + separator + current.getLastName() + separator + current.getEmail() + separator + current.getCode()
			+ separator + current.getPassword() + separator + current.isFullTime() + separator + current.getCareer() + separator + current.getContEvaluations());
			current = current.getNext();
		}
		pw.close();
	}
	
	//Serialization 
	
	public void saveEvaluationSystemData(EvaluationSystem es) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EVALUATION_SYSTEM_FILE_NAME));
		oos.writeObject(es);
		oos.close();
	}
	
	public void loadEvaluationSystemData(EvaluationSystem es) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EVALUATION_SYSTEM_FILE_NAME));
		es = (EvaluationSystem)ois.readObject();
		ois.close();
	}
	
}
