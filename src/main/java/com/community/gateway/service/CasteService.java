package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Caste;

public interface CasteService {
	
	Caste findById(Long casteId) throws ResourceNotFoundException;

	List<Caste> findAll();

	void delete(Long casteId);

	Caste save(@Valid Caste caste);
}
