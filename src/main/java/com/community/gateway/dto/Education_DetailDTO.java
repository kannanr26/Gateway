package com.community.gateway.dto;

import lombok.Data;

@Data
public class Education_DetailDTO {

	private long id;

	private PersonDTO personDTO;

	private int courses;

	private int education;
}
