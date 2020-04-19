package com.community.gateway.dto;

import lombok.Data;

@Data

public class Education_DetailDTO {

	private long id;

	private PersonDTO personDTO;

	private long courses;

	private long education;
	
	private String courseStr;

	private String educationStr;
	public Education_DetailDTO() {
	
	}
	public Education_DetailDTO( long course,long education) {
		this.courses=course;
		this.education=education;
		//this.personDTO=personDTO;
		
	}

	public long getId() {
		return id;
	}

	public PersonDTO getPersonDTO() {
		return personDTO;
	}

	public long getCourses() {
		return courses;
	}

	public long getEducation() {
		return education;
	}

	public String getCourseStr() {
		return courseStr;
	}

	public String getEducationStr() {
		return educationStr;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPersonDTO(PersonDTO personDTO) {
		this.personDTO = personDTO;
	}

	public void setCourses(long courses) {
		this.courses = courses;
	}

	public void setEducation(long education) {
		this.education = education;
	}

	public void setCourseStr(String courseStr) {
		this.courseStr = courseStr;
	}

	public void setEducationStr(String educationStr) {
		this.educationStr = educationStr;
	}
}
