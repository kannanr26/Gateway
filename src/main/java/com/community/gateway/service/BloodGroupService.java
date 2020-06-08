package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.BloodGroup;

public interface BloodGroupService {

	BloodGroup findById(Long bloodGroupId) throws ResourceNotFoundException;

	List<BloodGroup> findAll();

	void delete(Long bloodGroupId);

	BloodGroup save(@Valid BloodGroup bloodGroup);
}