package model;

import java.io.Serializable;

public class Evaluation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String topic;
	private int percentage;
	private String content;
	/**
	 * @param topic
	 * @param percentage
	 * @param content
	 */
	public Evaluation(String topic, int percentage, String content) {
		this.topic = topic;
		this.percentage = percentage;
		this.content = content;
	}
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * @return the percentage
	 */
	public int getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
