package com.community.gateway.dto;

import java.util.List;

import lombok.Data;

@Data
public class Family_DetailsDTO {

	private long id;

	private String familyName;

	private String registrationNumber;

	private AddressDTO address;

	private List<PersonDTO> personDTO;

}