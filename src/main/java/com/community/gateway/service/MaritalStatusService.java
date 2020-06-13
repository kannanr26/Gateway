package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.MaritalStatus;

public interface MaritalStatusService {

	MaritalStatus findById(Long maritalStatusId) throws ResourceNotFoundException;

	List<MaritalStatus> findAll();

	void delete(Long maritalStatusId);

	MaritalStatus save(@Valid MaritalStatus maritalStatus);
}