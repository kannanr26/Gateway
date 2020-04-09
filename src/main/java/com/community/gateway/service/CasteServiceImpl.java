package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Caste;
import com.community.gateway.model.repo.CasteRepository;

@Service
public class CasteServiceImpl implements CasteService {

	@Autowired
	CasteRepository casteRepository;

	@Override
	public Caste findById(Long casteId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Caste caste = casteRepository.findById(casteId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + casteId));
		return caste;
	}

	@Override
	public List<Caste> findAll() {
		List<Caste> list = new ArrayList<>();
		Iterable<Caste> customers = casteRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long casteId) {
		casteRepository.deleteById(casteId);

	}

	@Override
	public Caste save(@Valid Caste caste) {
		// TODO Auto-generated method stub
		return casteRepository.save(caste);
	}
}
