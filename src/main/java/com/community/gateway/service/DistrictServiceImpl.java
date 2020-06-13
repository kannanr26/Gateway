package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.District;
import com.community.gateway.model.repo.DistrictRepository;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictRepository districtRepository;

	@Override
	public District findById(Long districtId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		District district = districtRepository.findById(districtId)
				.orElseThrow(() -> new ResourceNotFoundException("Blood not found for this id :: " + districtId));
		return district;
	}

	@Override
	public List<District> findAll() {
		List<District> list = new ArrayList<>();
		Iterable<District> customers = districtRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long districtId) {
		districtRepository.deleteById(districtId);

	}

	@Override
	public District save(@Valid District district) {
		// TODO Auto-generated method stub
		System.out.println(" district :"+district.getDistrictName());
		return districtRepository.save(district);
	}
}