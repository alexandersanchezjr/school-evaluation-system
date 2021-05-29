/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author User
 *
 */
public class Activity extends Evaluation {
	
	private Calendar assignmentDate;
	private ArrayList<String> helpLinks;

	/**
	 * @param topic
	 * @param percentage
	 * @param content
	 */
	public Activity(String topic, int percentage, String content) {
		super(topic, percentage, content);
		helpLinks = new ArrayList<String>();
	}

}
