package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Student extends Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double finalAverageGrade;
	//private int contEvaluations;
	
	private Student parent;
	private Student left;
	private Student right;
	
	public Student(String name, String lastName, String email, String code) {
		super(name, lastName, email, code);
		setFinalAverageGrade(0.0);
	}
	
	public Student(String name, String lastName, String email, String code, double finalGrade) {
		super(name, lastName, email, code);
		finalAverageGrade = finalGrade;
	}

	/**
	 * @return the finalAverageGrade
	 */
	public double getFinalAverageGrade() {
		return finalAverageGrade;
	}

	/**
	 * @param finalAverageGrade the finalAverageGrade to set
	 */
	public void setFinalAverageGrade(double finalAverageGrade) {
		this.finalAverageGrade = finalAverageGrade;
	}
	
	public int compareByLastName(Student s1) {
		return getLastName().compareToIgnoreCase(s1.getLastName());
	}
	
	public int compareByFinalGrade(Student other) {
		if(finalAverageGrade == other.getFinalAverageGrade()) {
			return 0;
		}else if(finalAverageGrade > other.getFinalAverageGrade()) {
			return 1;
		}else {
			return -1;
		}
	}
		
	/**
	 * @return the parent
	 */
	public Student getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Student parent) {
		this.parent = parent;
	}

	/**
	 * @return the left
	 */
	public Student getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Student left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Student getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Student right) {
		this.right = right;
	}
	
	public String nodeToString(String separator) {
		return getName() + separator + getLastName() + separator + getCode() + separator + getFinalAverageGrade() + separator + LocalDateTime.now();
	}
	
//	public void increaseContEvaluation() {
//		contEvaluations++;
//	}
	
//	public void updateFinalAverageGrade(double newGrade, double percentage) {
//		increaseContEvaluation();
//		double grade = newGrade*percentage;
//		finalAverageGrade = (finalAverageGrade+grade)/contEvaluations;
//	}

}
