package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Family_Details;
import com.community.gateway.model.repo.Family_DetailsRepository;

@Service
public class Family_DetailsServiceImpl implements Family_DetailsService {

	@Autowired
	Family_DetailsRepository family_detailsRepository;

	@Override
	public Family_Details findById(Long family_detailsId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Family_Details family_details = family_detailsRepository.findById(family_detailsId).orElseThrow(
				() -> new ResourceNotFoundException("Family Details  not found for this id :: " + family_detailsId));
		return family_details;
	}

	@Override
	public List<Family_Details> findAll() {
		List<Family_Details> list = new ArrayList<>();
		Iterable<Family_Details> customers = family_detailsRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long family_detailsId) {
		family_detailsRepository.deleteById(family_detailsId);

	}

	@Override
	public Family_Details save(@Valid Family_Details family_details)throws Exception {
		// TODO Auto-generated method stub
		return family_detailsRepository.save(family_details);
	}

	@Override
	public Family_Details findByRegistrationNumber(@Valid String registrationNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Family_Details family_details = family_detailsRepository.findByRegistrationNumber(registrationNumber).orElseThrow(
				() -> new ResourceNotFoundException("Family Details not found for this registrationNumber :: " + registrationNumber));
		return family_details;
	}
}
