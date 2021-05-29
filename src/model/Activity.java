package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity extends Evaluation {
	
	private Calendar assignmentDate;
	private ArrayList<String> helpLinks;

	/**
	 * @param topic
	 * @param percentage
	 * @param content
	 */
	public Activity(String topic, int percentage, String content, Calendar date) {
		super(topic, percentage, content);
		assignmentDate = date;
		helpLinks = new ArrayList<String>();
	}

	/**
	 * @return the assignmentDate
	 */
	public Calendar getAssignmentDate() {
		return assignmentDate;
	}

	/**
	 * @param assignmentDate the assignmentDate to set
	 */
	public void setAssignmentDate(Calendar assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	/**
	 * @return the helpLinks
	 */
	public ArrayList<String> getHelpLinks() {
		return helpLinks;
	}

	/**
	 * @param helpLinks the helpLinks to set
	 */
	public void setHelpLinks(ArrayList<String> helpLinks) {
		this.helpLinks = helpLinks;
	}

}
