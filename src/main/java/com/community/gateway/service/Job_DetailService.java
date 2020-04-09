package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Job_Detail;

public interface Job_DetailService {

	Job_Detail findById(Long job_detailId) throws ResourceNotFoundException;

	List<Job_Detail> findAll();

	void delete(Long job_detailId);

	Job_Detail save(@Valid Job_Detail job_detail);
}
