package com.community.gateway.dto;

import java.util.List;

import lombok.Data;

@Data
public class PersonDTO {

	private long id;
	private String personName;
	private String gender;
	private List<Education_DetailDTO> educationDetailsDTOL;
	private Education_DetailDTO education;
	private Job_DetailDTO job;
	private Business_DetailDTO business;
	private RelationShipsDTO relation;
	// private OccupationDTO occupation;
	private List<Job_DetailDTO> jobDetailsDTOL;
	private List<Business_DetailDTO> businessDetailsDTOL;
	//private List<RelationShipsDTO> relationShip;

}