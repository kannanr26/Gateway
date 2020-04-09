package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.PersonalDetailsDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface PersonalDetailsLogical {

	List<PersonalDetailsDTO> findAll();

	PersonalDetailsDTO findById(Long personaldetailsId)throws ResourceNotFoundException;

	//PersonalDetailsDTO save(@Valid PersonalDetails personaldetailsDTO);

	void delete(Long personaldetailsId) throws ResourceNotFoundException;

	PersonalDetailsDTO save(@Valid PersonalDetailsDTO personaldetailsDto);

}
