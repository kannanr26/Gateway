package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Occupation_Detail;
import com.community.gateway.model.repo.Occupation_DetailRepository;

@Service
public class Occupation_DetailServiceImpl implements Occupation_DetailService {

	@Autowired
	Occupation_DetailRepository occupation_detailRepository;

	@Override
	public Occupation_Detail findById(Long occupation_detailId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Occupation_Detail occupation_detail = occupation_detailRepository.findById(occupation_detailId).orElseThrow(
				() -> new ResourceNotFoundException("Operator not found for this id :: " + occupation_detailId));
		return occupation_detail;
	}

	@Override
	public List<Occupation_Detail> findAll() {
		List<Occupation_Detail> list = new ArrayList<>();
		Iterable<Occupation_Detail> customers = occupation_detailRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long occupation_detailId) {
		occupation_detailRepository.deleteById(occupation_detailId);

	}

	@Override
	public Occupation_Detail save(@Valid Occupation_Detail occupation_detail) {
		// TODO Auto-generated method stub
		return occupation_detailRepository.save(occupation_detail);
	}
}
