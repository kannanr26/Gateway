package com.community.gateway.dto;

import java.util.List;

import com.community.gateway.model.e_num.EGender;

import lombok.Data;

@Data
public class PersonDTO {
	private long id;
	private String personName;
	private EGender gender;
	private List<Education_DetailDTO> educationDetails;
	private List<Job_DetailDTO> jobDetail;
	private List<RelationShipsDTO> relationShip;
	private Family_DetailsDTO familyDetails;
	private AddressDTO personalAddress;
}