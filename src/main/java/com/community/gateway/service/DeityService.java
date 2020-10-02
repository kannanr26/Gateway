package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Deity;

public interface DeityService {
	
	Deity findById(Long deityId) throws ResourceNotFoundException;

	List<Deity> findAll();

	void delete(Long deityId);

	Deity save(@Valid Deity deity);

	List<Deity> findByCityId(Long cityId);
}
