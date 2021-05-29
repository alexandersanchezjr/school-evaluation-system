package model;

import java.util.Calendar;

public class Workshop extends Activity {

	private String answers;
	
	public Workshop(String topic, int percentage, String content, Calendar date, String answers) {
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
