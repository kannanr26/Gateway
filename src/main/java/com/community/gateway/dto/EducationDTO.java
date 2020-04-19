package com.community.gateway.dto;

import lombok.Data;

@Data

public class EducationDTO {

	private long id;

	private String educationName;

	public long getId() {
		return id;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
}
