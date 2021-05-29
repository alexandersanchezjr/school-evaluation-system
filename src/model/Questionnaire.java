package model;

import java.util.Calendar;

public class Questionnaire extends Activity {

	private int attempts;
	
	public Questionnaire(String topic, int percentage, String content, Calendar date, int attempts) {
		super(topic, percentage, content, date);
		this.setAttempts(attempts);
	}

	/**
	 * @return the attempts
	 */
	public int getAttempts() {
		return attempts;
	}

	/**
	 * @param attempts the attempts to set
	 */
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

}
