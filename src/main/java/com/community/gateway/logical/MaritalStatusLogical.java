package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.MaritalStatusDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface MaritalStatusLogical {

	List<MaritalStatusDTO> findAll();

	MaritalStatusDTO findById(Long maritalStatusId)throws ResourceNotFoundException;

	void delete(Long maritalStatusId) throws ResourceNotFoundException;

	MaritalStatusDTO save(@Valid MaritalStatusDTO maritalStatusDto);

}