package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Occupation;
import com.community.gateway.model.repo.OccupationRepository;

@Service
public class OccupationServiceImpl implements OccupationService {

	@Autowired
	OccupationRepository occupationRepository;

	@Override
	public Occupation findById(Long occupationId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Occupation occupation = occupationRepository.findById(occupationId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + occupationId));
		return occupation;
	}

	@Override
	public List<Occupation> findAll() {
		List<Occupation> list = new ArrayList<>();
		Iterable<Occupation> customers = occupationRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long occupationId) {
		occupationRepository.deleteById(occupationId);

	}

	@Override
	public Occupation save(@Valid Occupation occupation) {
		// TODO Auto-generated method stub
		return occupationRepository.save(occupation);
	}
}
