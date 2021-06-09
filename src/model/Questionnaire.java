package model;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Calendar;
=======
>>>>>>> 975453f0fc0e99e9c9709833f49f00452b6be498

public class Questionnaire extends Activity {

	private int attempts;
	
	public Questionnaire(String topic, int percentage, String content, LocalDate date, int attempts) {
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
