package com.community.gateway.model.e_num;

import lombok.Getter;

public enum EBloodGroup {
	
	
	A_POSITIVE("A+"),
	A_NEGATIVE("A-"),
	O_POSITIVE("O+"),
	O_NEGATIVE("O-"),
	B_POSITIVE("B+"),
	B_NEGATIVE("B-"),
	AB_POSITIVE("AB+"),
	AB_NEGATIVE("AB-");
	
	@Getter
	private final String label;
	private EBloodGroup(String label){
		this.label=label;
	}
}
