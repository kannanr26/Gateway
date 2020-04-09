package com.community.gateway.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class AddressDTO implements Serializable {
	// person who is associated with the address

	private long id;

	private int houseNumber;

	private String streetName;

	private String city;

	private String state;

	private String zipCode;

	private Family_DetailsDTO familyDetails;

	private PersonDTO personDTO;

}