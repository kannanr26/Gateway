package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.JobTitle;

public interface JobTitleService {
	
	JobTitle findById(Long jobtitleId) throws ResourceNotFoundException;

	List<JobTitle> findAll();

	void delete(Long jobtitleId);

	JobTitle save(@Valid JobTitle jobtitle);
}
