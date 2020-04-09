package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Education;

public interface EducationService {
	Education findById(Long educationId) throws ResourceNotFoundException;

	List<Education> findAll();

	void delete(Long educationId);

	Education save(@Valid Education education);
}
