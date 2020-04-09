package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Gothiram;
import com.community.gateway.model.repo.GothiramRepository;

@Service
public class GothiramServiceImpl implements GothiramService {

	@Autowired
	GothiramRepository gothiramRepository;

	@Override
	public Gothiram findById(Long gothiramId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Gothiram gothiram = gothiramRepository.findById(gothiramId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + gothiramId));
		return gothiram;
	}

	@Override
	public List<Gothiram> findAll() {
		List<Gothiram> list = new ArrayList<>();
		Iterable<Gothiram> customers = gothiramRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long gothiramId) {
		gothiramRepository.deleteById(gothiramId);

	}

	@Override
	public Gothiram save(@Valid Gothiram gothiram) {
		// TODO Auto-generated method stub
		return gothiramRepository.save(gothiram);
	}
}
