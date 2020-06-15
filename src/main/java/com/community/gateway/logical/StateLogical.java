package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.StateDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface StateLogical {

	List<StateDTO> findAll();

	StateDTO findById(Long stateId)throws ResourceNotFoundException;

	void delete(Long stateId) throws ResourceNotFoundException;

	StateDTO save(@Valid StateDTO stateDto);

	List<StateDTO> findAllByCountryId(Long countryId);

}