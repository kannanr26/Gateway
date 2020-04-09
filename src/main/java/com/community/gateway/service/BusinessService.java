package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Business;

public interface BusinessService {
	
	Business findById(Long businessId) throws ResourceNotFoundException;

	List<Business> findAll();

	void delete(Long businessId);

	Business save(@Valid Business business);
}
