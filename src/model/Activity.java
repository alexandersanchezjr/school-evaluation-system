package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Activity extends Evaluation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate assignmentDate;
	private ArrayList<String> helpLinks;

	/**
	 * @param topic
	 * @param percentage
	 * @param content
	 */
	public Activity(String topic, int percentage, String content, LocalDate date) {
		super(topic, percentage, content);
		assignmentDate = date;
		helpLinks = new ArrayList<String>();
	}

	/**
	 * @return the assignmentDate
	 */
	public LocalDate getAssignmentDate() {
		return assignmentDate;
	}

	/**
	 * @param assignmentDate the assignmentDate to set
	 */
	public void setAssignmentDate(LocalDate assignmentDate) {
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
