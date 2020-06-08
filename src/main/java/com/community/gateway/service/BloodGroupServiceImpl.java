package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.BloodGroup;
import com.community.gateway.model.repo.BloodGroupRepository;

@Service
public class BloodGroupServiceImpl implements BloodGroupService {

	@Autowired
	BloodGroupRepository bloodGroupRepository;

	@Override
	public BloodGroup findById(Long bloodGroupId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		BloodGroup bloodGroup = bloodGroupRepository.findById(bloodGroupId)
				.orElseThrow(() -> new ResourceNotFoundException("Blood not found for this id :: " + bloodGroupId));
		return bloodGroup;
	}

	@Override
	public List<BloodGroup> findAll() {
		List<BloodGroup> list = new ArrayList<>();
		Iterable<BloodGroup> customers = bloodGroupRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long bloodGroupId) {
		bloodGroupRepository.deleteById(bloodGroupId);

	}

	@Override
	public BloodGroup save(@Valid BloodGroup bloodGroup) {
		// TODO Auto-generated method stub
		System.out.println(" bloodGroup :"+bloodGroup.getBloodGroupName());
		return bloodGroupRepository.save(bloodGroup);
	}
}