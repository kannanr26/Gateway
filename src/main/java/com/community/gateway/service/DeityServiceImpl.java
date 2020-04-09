package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Deity;
import com.community.gateway.model.repo.DeityRepository;

@Service
public class DeityServiceImpl implements DeityService {

	@Autowired
	DeityRepository deityRepository;

	@Override
	public Deity findById(Long deityId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Deity deity = deityRepository.findById(deityId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + deityId));
		return deity;
	}

	@Override
	public List<Deity> findAll() {
		List<Deity> list = new ArrayList<>();
		Iterable<Deity> customers = deityRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long deityId) {
		deityRepository.deleteById(deityId);

	}

	@Override
	public Deity save(@Valid Deity deity) {
		// TODO Auto-generated method stub
		return deityRepository.save(deity);
	}
}
