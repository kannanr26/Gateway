package com.community.gateway.dto;

import lombok.Data;

//@Data
public class CoursesDTO {

	private long id;

	private String courseName;

	public long getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
