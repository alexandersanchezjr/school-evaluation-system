package model;

public class Exam extends Evaluation {

	private int timeLimit;
	
	public Exam(String topic, int percentage, String content, int timeLimit) {
		super(topic, percentage, content);
		this.setTimeLimit(timeLimit);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the timeLimit
	 */
	public int getTimeLimit() {
		return timeLimit;
	}

	/**
	 * @param timeLimit the timeLimit to set
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

}
