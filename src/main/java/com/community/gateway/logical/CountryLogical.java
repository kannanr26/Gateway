package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.CountryDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface CountryLogical {

	List<CountryDTO> findAll();

	CountryDTO findById(Long countryId)throws ResourceNotFoundException;

	void delete(Long countryId) throws ResourceNotFoundException;

	CountryDTO save(@Valid CountryDTO countryDto);

}