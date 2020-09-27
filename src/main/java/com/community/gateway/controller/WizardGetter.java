package com.community.gateway.controller;

import java.util.List;

import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.dto.CasteDTO;
import com.community.gateway.dto.CountryDTO;
import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.EducationDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.dto.RelationShipNameDTO;
import com.community.gateway.model.e_num.EOperator;

import lombok.Data;

@Data
public class WizardGetter {
	List<KulamDTO> kulams;
	List<GothiramDTO> gothirams;
	List<CasteDTO> castes;
	List<DeityDTO> deitys;
	List<BloodGroupDTO> bloodGroups;
	List<BusinessDTO> business;
	List<JobDTO> jobs;
	List<JobTitleDTO> jobTitles;
	List<EducationDTO> educations;
	List<CoursesDTO> courses;
	List<RelationShipNameDTO> relationShipNames;
	List<CountryDTO> countries;
	List<OperatorDTO> operators;
	List<OperatorDTO> operatorsCollected;
	List<OperatorDTO> operatorsEntered;
	List<OperatorDTO> operatorsComputed;
	

	/*public List<OperatorDTO> getOperatorCollected(){
		setOperatorsCollected( getOperators().stream().
	//	setOperatorsCollected( getOperators().stream().findAny(x -> x.getOperatorType().equals(EOperator.COLLECTED)) );
	}*/
}
