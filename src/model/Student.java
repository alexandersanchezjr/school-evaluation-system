package model;

public class Student extends Member {

	private double finalAverageGrade;
	//private int contEvaluations;
	
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
	
//	public void increaseContEvaluation() {
//		contEvaluations++;
//	}
	
//	public void updateFinalAverageGrade(double newGrade, double percentage) {
//		increaseContEvaluation();
//		double grade = newGrade*percentage;
//		finalAverageGrade = (finalAverageGrade+grade)/contEvaluations;
//	}

}
