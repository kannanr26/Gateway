package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Country;

public interface CountryService {

	Country findById(Long countryId) throws ResourceNotFoundException;

	List<Country> findAll();

	void delete(Long countryId);

	Country save(@Valid Country country);
}