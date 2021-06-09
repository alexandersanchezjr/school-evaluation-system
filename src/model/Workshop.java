package model;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Calendar;
=======
>>>>>>> 975453f0fc0e99e9c9709833f49f00452b6be498

public class Workshop extends Activity {

	private String answers;
	
	public Workshop(String topic, int percentage, String content, LocalDate date, String answers) {
		super(topic, percentage, content, date);
		this.setAnswers(answers);
	}

	/**
	 * @return the answers
	 */
	public String getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(String answers) {
		this.answers = answers;
	}

}
