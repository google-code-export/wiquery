package org.odlabs.wiquery.demo.model;

import java.io.Serializable;

public class Task implements Serializable {

	public static enum TaskState {
		TODO, IN_PROGRESS, DONE
	};
	
	private int priority;
	
	private String title;
	
	private String description;
	
	private TaskState state;
	
	private String developer;
	
	private float duration;

	public Task(int priority, String title, String description,
			TaskState state, String developer, float duration) {
		super();
		this.priority = priority;
		this.title = title;
		this.description = description;
		this.state = state;
		this.developer = developer;
		this.duration = duration;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}
	
	
	
}
