package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Occupation;

public interface OccupationService {

	Occupation findById(Long occupationId) throws ResourceNotFoundException;

	List<Occupation> findAll();

	void delete(Long occupationId);

	Occupation save(@Valid Occupation occupation);
}
