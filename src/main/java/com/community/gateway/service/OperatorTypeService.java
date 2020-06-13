package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.OperatorType;

public interface OperatorTypeService {

	OperatorType findById(Long bloodGroupId) throws ResourceNotFoundException;

	List<OperatorType> findAll();

	void delete(Long bloodGroupId);

	OperatorType save(@Valid OperatorType bloodGroup);
}