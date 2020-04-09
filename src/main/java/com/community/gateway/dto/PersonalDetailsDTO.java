package com.community.gateway.dto;

import java.time.LocalDate;

import com.community.gateway.model.e_num.EBloodGroup;
import com.community.gateway.model.e_num.EGender;

import lombok.Data;

@Data
public class PersonalDetailsDTO {
	private long id;
	private EGender gender;
	private EBloodGroup bloodGroup;
	private LocalDate dob;
}
