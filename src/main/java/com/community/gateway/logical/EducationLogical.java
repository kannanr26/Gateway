package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.EducationDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface EducationLogical {

	List<EducationDTO> findAll();

	EducationDTO findById(Long educationId)throws ResourceNotFoundException;
	
	EducationDTO findByEducationName(String education)throws ResourceNotFoundException;

	//EducationDTO save(@Valid Education educationDTO);

	void delete(Long educationId) throws ResourceNotFoundException;

	EducationDTO save(@Valid EducationDTO educationDto);

}
