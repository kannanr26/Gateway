package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Education_Detail;

public interface Education_DetailService {
	Education_Detail findById(Long education_detailId) throws ResourceNotFoundException;

	List<Education_Detail> findAll();

	void delete(Long education_detailId);

	Education_Detail save(@Valid Education_Detail education_detail);
}
