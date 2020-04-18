package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Operator;

public interface OperatorService{

	Operator findById(Long operatorId) throws ResourceNotFoundException;

	List<Operator> findAll();

	void delete(Long operatorId);

	Operator save(@Valid Operator operator);

	Operator findByMobileNumber(long mobileNumber) throws ResourceNotFoundException;

}
