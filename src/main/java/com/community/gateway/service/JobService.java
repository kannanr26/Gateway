package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Job;

public interface JobService {

	Job findById(Long jobId) throws ResourceNotFoundException;

	List<Job> findAll();

	void delete(Long jobId);

	Job save(@Valid Job job);

	Job findByRoleName(String roleName) throws ResourceNotFoundException;
}
