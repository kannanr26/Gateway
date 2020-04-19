package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Education;
import com.community.gateway.model.repo.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	EducationRepository educationRepository;

	@Override
	public Education findById(Long educationId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Education education = educationRepository.findById(educationId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + educationId));
		return education;
	}

	@Override
	public List<Education> findAll() {
		List<Education> list = new ArrayList<>();
		Iterable<Education> customers = educationRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long educationId) {
		educationRepository.deleteById(educationId);

	}

	@Override
	public Education save(@Valid Education education) {
		// TODO Auto-generated method stub
		return educationRepository.save(education);
	}

	@Override
	public Education findByEducationName(String educationName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Education education = educationRepository.findByEducationName(educationName)
				.orElseThrow(() -> new ResourceNotFoundException("Education Name not found for this id :: " + educationName));
		return education;
	}
}
