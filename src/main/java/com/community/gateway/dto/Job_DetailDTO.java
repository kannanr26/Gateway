package com.community.gateway.dto;

import lombok.Data;

@Data
public class Job_DetailDTO {
	private long id;
	private PersonDTO personDTO;
	private long department;
	private long job;
	private long jobTitle;
	private int yearsOfExperience;
	
	private String departmentStr;
	private String jobStr;
	private String jobTitleStr;
	public Job_DetailDTO() {
		
	}
	public Job_DetailDTO(long job,long jobTitle, long department,int yearsOfExperience) {
		this.job=job;
		this.jobTitle=jobTitle;
		this.department=department;
		this.yearsOfExperience=yearsOfExperience;
	}
	public long getId() {
		return id;
	}
	public PersonDTO getPersonDTO() {
		return personDTO;
	}
	public long getDepartment() {
		return department;
	}
	public long getJob() {
		return job;
	}
	public long getJobTitle() {
		return jobTitle;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public String getDepartmentStr() {
		return departmentStr;
	}
	public String getJobStr() {
		return jobStr;
	}
	public String getJobTitleStr() {
		return jobTitleStr;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setPersonDTO(PersonDTO personDTO) {
		this.personDTO = personDTO;
	}
	public void setDepartment(long department) {
		this.department = department;
	}
	public void setJob(long job) {
		this.job = job;
	}
	public void setJobTitle(long jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public void setDepartmentStr(String departmentStr) {
		this.departmentStr = departmentStr;
	}
	public void setJobStr(String jobStr) {
		this.jobStr = jobStr;
	}
	public void setJobTitleStr(String jobTitleStr) {
		this.jobTitleStr = jobTitleStr;
	}
}
