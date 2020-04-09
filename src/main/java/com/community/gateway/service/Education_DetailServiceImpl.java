package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Education_Detail;
import com.community.gateway.model.repo.Education_DetailRepository;

@Service
public class Education_DetailServiceImpl implements Education_DetailService {

	@Autowired
	Education_DetailRepository education_detailRepository;

	@Override
	public Education_Detail findById(Long education_detailId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Education_Detail education_detail = education_detailRepository.findById(education_detailId).orElseThrow(
				() -> new ResourceNotFoundException("Operator not found for this id :: " + education_detailId));
		return education_detail;
	}

	@Override
	public List<Education_Detail> findAll() {
		List<Education_Detail> list = new ArrayList<>();
		Iterable<Education_Detail> customers = education_detailRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long education_detailId) {
		education_detailRepository.deleteById(education_detailId);

	}

	@Override
	public Education_Detail save(@Valid Education_Detail education_detail) {
		// TODO Auto-generated method stub
		return education_detailRepository.save(education_detail);
	}
}
