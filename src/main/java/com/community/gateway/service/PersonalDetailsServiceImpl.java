package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.PersonalDetails;
import com.community.gateway.model.repo.PersonalDetailsRepository;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

	@Autowired
	PersonalDetailsRepository personaldetailsRepository;

	@Override
	public PersonalDetails findById(Long personaldetailsId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		PersonalDetails personaldetails = personaldetailsRepository.findById(personaldetailsId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + personaldetailsId));
		return personaldetails;
	}

	@Override
	public List<PersonalDetails> findAll() {
		List<PersonalDetails> list = new ArrayList<>();
		Iterable<PersonalDetails> customers = personaldetailsRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long personaldetailsId) {
		personaldetailsRepository.deleteById(personaldetailsId);

	}

	@Override
	public PersonalDetails save(@Valid PersonalDetails personaldetails) {
		// TODO Auto-generated method stub
		return personaldetailsRepository.save(personaldetails);
	}
}
