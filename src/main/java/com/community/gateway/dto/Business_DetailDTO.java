package com.community.gateway.dto;

import org.hibernate.type.YesNoType;

import lombok.Data;

@Data
public class Business_DetailDTO {

	private long id;

	private PersonDTO personDTO;

	private long business;
	private String businessStr;

	private int yearsOfExperience;
	public Business_DetailDTO() {
	
	}
	public Business_DetailDTO(long business,int yearsOfExperience) {
		this.business=business;
		this.yearsOfExperience=yearsOfExperience;
	}
	public long getId() {
		return id;
	}
	public PersonDTO getPersonDTO() {
		return personDTO;
	}
	public long getBusiness() {
		return business;
	}
	public String getBusinessStr() {
		return businessStr;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setPersonDTO(PersonDTO personDTO) {
		this.personDTO = personDTO;
	}
	public void setBusiness(long business) {
		this.business = business;
	}
	public void setBusinessStr(String businessStr) {
		this.businessStr = businessStr;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
}
