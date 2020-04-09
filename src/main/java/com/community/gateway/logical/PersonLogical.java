package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.PersonDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface PersonLogical {

	List<PersonDTO> findAll();

	PersonDTO findById(Long personId)throws ResourceNotFoundException;

	//PersonDTO save(@Valid Person personDTO);

	void delete(Long personId) throws ResourceNotFoundException;

	PersonDTO save(@Valid PersonDTO personDto);

}
