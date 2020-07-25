package com.community.gateway.logical;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.dto.Business_DetailDTO;
import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.dto.EducationDTO;
import com.community.gateway.dto.Education_DetailDTO;
import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.dto.Job_DetailDTO;
import com.community.gateway.dto.PersonDTO;
import com.community.gateway.dto.RelationShipsDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.BusinessMapper;
import com.community.gateway.mapper.EducationMapper;
import com.community.gateway.mapper.JobMapper;
import com.community.gateway.mapper.PersonMapper;
import com.community.gateway.model.e_num.ERelation;
import com.community.gateway.service.PersonService;

@Service
public class PersonLogicalImpl implements PersonLogical {

	@Autowired
	PersonService personService;
	
	@Autowired
	RelationShipsLogical relationShipLogical;
	@Autowired
	CoursesLogical courseLogical;
	
	@Autowired
	EducationLogical educationLogical;
	
	@Autowired
	Education_DetailLogical educationDetailsLogical;
	
	@Autowired
	BusinessLogical businessLogical;
	
	@Autowired
	Business_DetailLogical businessDetailLogic;
	
	@Autowired
	JobLogical jobLogical;

	@Autowired
	JobTitleLogical jobTitleLogical;
	
	@Autowired
	DepartmentLogical departmentLogical;
	
	@Autowired
	Job_DetailLogical jobDetailLogic;
	
	@Autowired
	PersonMapper personMapper;
	
	@Autowired
	EducationMapper educationMapper;

	@Autowired
	JobMapper jobMapper;
	
	@Autowired
	BusinessMapper businessMapper;
	
	@Override
	public List<PersonDTO> findAll() {
		// TODO Auto-generated method stub
		return personMapper.toPersonDTOs(personService.findAll());
	}

	@Override
	public PersonDTO findById(Long personId) throws ResourceNotFoundException {
		return personMapper.toPersonDTO(personService.findById(personId));
	}

	@Override
	public PersonDTO save(@Valid PersonDTO personDto,Long groupId) throws Exception{
		// TODO Auto-generated method stub
		
		EducationDTO educationDTO=	educationLogical.findByEducationName( personDto.getEducation().getEducationStr());
		CoursesDTO coursesDTO= courseLogical.findByCourseName(personDto.getEducation().getCourseStr());
		
		BusinessDTO businessDTO=	businessLogical.findByBusinessName(personDto.getBusiness().getBusinessStr());
		
		JobDTO jobDTO=jobLogical.findByJobName( personDto.getJob().getJobStr());
		JobTitleDTO jobTitleDTO=jobTitleLogical.findByJobTitleName(personDto.getJob().getJobTitleStr());
		CoursesDTO courseJobDTO=courseLogical.findByCourseName(personDto.getJob().getDepartmentStr());
		Education_DetailDTO educationDetailsToSave;
		Job_DetailDTO jobDetailsToSave;
		Business_DetailDTO businessDetailToSave;
		
		List<Education_DetailDTO> educationDetailsList =personDto.getEducationDetailsDTOL();
		if(educationDetailsList==null)
		{
			educationDetailsList=new ArrayList<Education_DetailDTO>();
		}
		educationDetailsToSave=new Education_DetailDTO(coursesDTO.getId(),educationDTO.getId());
		educationDetailsList.add(educationDetailsToSave);
		personDto.setEducationDetailsDTOL(educationDetailsList);
		
		List<Job_DetailDTO> jobDetails=personDto.getJobDetailsDTOL();
		if(jobDetails==null) {
			jobDetails=new ArrayList<Job_DetailDTO>();
			
		}
		jobDetailsToSave= new Job_DetailDTO(jobDTO.getId(),jobTitleDTO.getId(),courseJobDTO.getId(),personDto.getJob().getYearsOfExperience());
		jobDetails.add(jobDetailsToSave);
		personDto.setJobDetailsDTOL(jobDetails);
		
		List<Business_DetailDTO> business_detailsDTO=personDto.getBusinessDetailsDTOL();
		if(business_detailsDTO==null) {
			business_detailsDTO=new ArrayList<Business_DetailDTO>();
		}
		businessDetailToSave=new Business_DetailDTO(businessDTO.getId() ,personDto.getBusiness().getYearsOfExperience());
		business_detailsDTO.add(businessDetailToSave);
		personDto.setBusinessDetailsDTOL(business_detailsDTO);		

		
		PersonDTO personDTOSaved= personMapper.toPersonDTO(personService.save(personMapper.toPerson(personDto)));
		educationDetailsToSave.setPersonDTO(personDTOSaved);
		jobDetailsToSave.setPersonDTO(personDTOSaved);
		businessDetailToSave.setPersonDTO(personDTOSaved);
		
	    educationDetailsLogical.save(educationDetailsToSave);
	    jobDetailLogic.save(jobDetailsToSave);
	    businessDetailLogic.save(businessDetailToSave);
	    
	     RelationShipsDTO rel = null;
		/*
		 * if(personDto.getRelation().equals(ERelation.SELF)) { rel=new
		 * RelationShipsDTO(personDTOSaved.getId(),personDTOSaved.getId(),personDto.
		 * getRelation().getRelation()); }else { rel=new
		 * RelationShipsDTO(personDTOSaved.getId(),personDto.getRelation().getMasterId()
		 * ,personDto.getRelation().getRelation()); }
		 */
	    relationShipLogical.save(rel);
		
	    return personDTOSaved;
	}

	@Override
	public void delete(Long personId)throws ResourceNotFoundException {
		personService.delete(personId);

	}

}
