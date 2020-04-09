package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.OccupationDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface OccupationLogical {

	List<OccupationDTO> findAll();

	OccupationDTO findById(Long occupationId)throws ResourceNotFoundException;

	//OccupationDTO save(@Valid Occupation occupationDTO);

	void delete(Long occupationId) throws ResourceNotFoundException;

	OccupationDTO save(@Valid OccupationDTO occupationDto);

}
