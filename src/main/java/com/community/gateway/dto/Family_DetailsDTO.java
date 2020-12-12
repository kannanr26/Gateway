package com.community.gateway.dto;

import java.util.Date;
import java.util.List;

import com.community.gateway.model.e_num.EGender;

import lombok.Data;

@Data
public class Family_DetailsDTO {

	private long id;

	private String familyName;

	private String registrationNumber;
	private Date registrationDate;
	private KulamDTO selectedKulams;
	private List<KulamDTO> kulams;
	private GothiramDTO selectedGothirams;
	private CasteDTO selectedCastes;
	private DeityDTO selectedDeitys;
	private OperatorDTO selectedOperators;
	private OperatorDTO selectedCollectedOperator;
	private OperatorDTO selectedEnteredOperator;
	private OperatorDTO selectedComputedOperator;
	private List<GothiramDTO> gothirams;
	private List<CasteDTO> castes;
	private List<DeityDTO> deitys;
	private List<OperatorDTO> operators;
	private List<OperatorDTO> collectedOperator;
	private List<OperatorDTO> enteredOperator;
	private List<OperatorDTO> computedOperator;
	private CountryDTO selectedCountry;
	private StateDTO selectedState;
	private DistrictDTO selectedDistrict;
	private CityDTO selectedCity;
	private List<CountryDTO> countries;
	private BusinessDTO selectedBusiness;
	private List<BusinessDTO> business;
	private BloodGroupDTO selectedBloodGroup;
	private List<BloodGroupDTO> bloodGroups;
	private Job_DetailDTO jobDetails;
	private List<JobDTO> jobs;
	private List<JobTitleDTO> jobTitles;
	private Education_DetailDTO educationDetails;
	private List<EducationDTO> educations;
	private List<CoursesDTO> courses;
	private List<RelationShipNameDTO> relationShipNames;
	private List<EGender> genders;
	private List<MaritalStatusDTO> maritalStatuies;
	
	
	private AddressDTO address=new AddressDTO();

	private List<PersonDTO> persons;


}