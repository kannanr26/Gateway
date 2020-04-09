package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Operator_LoginDetails;

public interface Operator_LoginDetailsService {

	Operator_LoginDetails findById(Long operator_logindetailsId) throws ResourceNotFoundException;

	List<Operator_LoginDetails> findAll();

	void delete(Long operator_logindetailsId);

	Operator_LoginDetails save(@Valid Operator_LoginDetails operator_logindetails);
}
