package com.community.gateway.dto;

import lombok.Data;

@Data
public class Business_DetailDTO {

	private long id;

	private PersonDTO personDTO;

	private int business;

	private int yearsOfExperience;
}
