package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Business;
import com.community.gateway.model.repo.BusinessRepository;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	BusinessRepository businessRepository;

	@Override
	public Business findById(Long businessId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Business business = businessRepository.findById(businessId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + businessId));
		return business;
	}
	@Override
	public Business findByBusinessName(String  businessName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Business business = businessRepository.findByBusinessName(businessName)
				.orElseThrow(() -> new ResourceNotFoundException("Business name not found for this id :: " + businessName));
		return business;
	}

	@Override
	public List<Business> findAll() {
		List<Business> list = new ArrayList<>();
		Iterable<Business> customers = businessRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long businessId) {
		businessRepository.deleteById(businessId);

	}

	@Override
	public Business save(@Valid Business business) {
		// TODO Auto-generated method stub
		return businessRepository.save(business);
	}
}
