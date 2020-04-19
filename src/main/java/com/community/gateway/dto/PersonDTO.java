package com.community.gateway.dto;

import java.util.List;

import com.community.gateway.model.e_num.EGender;

import lombok.Data;

@Data
public class PersonDTO {

	private long id;
	private String personName;
	private EGender gender;
	private List<Education_DetailDTO> educationDetailsDTOL;
	private Education_DetailDTO education;
	private Job_DetailDTO job;
	private Business_DetailDTO business;
	private RelationShipsDTO relation;
	// private OccupationDTO occupation;
	private List<Job_DetailDTO> jobDetailsDTOL;
	private List<Business_DetailDTO> businessDetailsDTOL;
	private List<RelationShipsDTO> relationShip;

	public Education_DetailDTO getEducation() {
		return education;
	}

	public Job_DetailDTO getJob() {
		return job;
	}

	public Business_DetailDTO getBusiness() {
		return business;
	}

	public void setEducation(Education_DetailDTO education) {
		this.education = education;
	}

	public void setJob(Job_DetailDTO job) {
		this.job = job;
	}

	public void setBusiness(Business_DetailDTO business) {
		this.business = business;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public EGender getGender() {
		return gender;
	}

	public void setGender(EGender gender) {
		this.gender = gender;
	}

	public List<Education_DetailDTO> getEducationDetailsDTOL() {

		return educationDetailsDTOL;
	}

	public void setEducationDetailsDTOL(List<Education_DetailDTO> educationDetails) {
		this.educationDetailsDTOL = educationDetails;
	}

	public List<Job_DetailDTO> getJobDetailsDTOL() {
		return jobDetailsDTOL;
	}

	public void setJobDetailsDTOL(List<Job_DetailDTO> jobDetail) {
		this.jobDetailsDTOL = jobDetail;
	}

	public List<Business_DetailDTO> getBusinessDetailsDTOL() {
		return businessDetailsDTOL;
	}

	public void setBusinessDetailsDTOL(List<Business_DetailDTO> businessDetailsDTOL) {
		this.businessDetailsDTOL = businessDetailsDTOL;
	}

	public List<RelationShipsDTO> getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(List<RelationShipsDTO> relationShip) {
		this.relationShip = relationShip;
	}

	public AddressDTO getPersonalAddress() {
		return personalAddress;
	}

	public void setPersonalAddress(AddressDTO personalAddress) {
		this.personalAddress = personalAddress;
	}

	private Family_DetailsDTO familyDetails;

	private AddressDTO personalAddress;

	public Family_DetailsDTO getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(Family_DetailsDTO familyDetails) {
		this.familyDetails = familyDetails;
	}

	public RelationShipsDTO getRelation() {
		return relation;
	}

	public void setRelation(RelationShipsDTO relation) {
		this.relation = relation;
	}
}