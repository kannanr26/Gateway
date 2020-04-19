package com.community.gateway.dto;

import lombok.Data;

@Data
public class BusinessDTO {

	private long id;

	private String businessName;

	public long getId() {
		return id;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

}