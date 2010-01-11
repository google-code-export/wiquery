package com.kodcu.data;

import java.io.Serializable;

public class Project implements Serializable{
	
	private static final long serialVersionUID = 8618404086641083514L;
	
	private int id;
	private String projectName;
	private String creator;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	

}
