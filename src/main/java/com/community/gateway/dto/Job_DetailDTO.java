package com.community.gateway.dto;

import lombok.Data;

@Data
public class Job_DetailDTO {
	private long id;
	private PersonDTO personDTO;
	private int department;
	private int job;
	private int jobTitle;
	private int yearsOfExperience;
}
