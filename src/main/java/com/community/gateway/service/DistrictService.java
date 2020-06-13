package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.District;

public interface DistrictService {

	District findById(Long districtId) throws ResourceNotFoundException;

	List<District> findAll();

	void delete(Long districtId);

	District save(@Valid District district);
}