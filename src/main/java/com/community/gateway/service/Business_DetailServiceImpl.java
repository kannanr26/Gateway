package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Business_Detail;
import com.community.gateway.model.repo.Business_DetailRepository;

@Service
public class Business_DetailServiceImpl implements Business_DetailService {

	@Autowired
	Business_DetailRepository business_detailRepository;

	@Override
	public Business_Detail findById(Long business_detailId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Business_Detail business_detail = business_detailRepository.findById(business_detailId).orElseThrow(
				() -> new ResourceNotFoundException("Operator not found for this id :: " + business_detailId));
		return business_detail;
	}

	@Override
	public List<Business_Detail> findAll() {
		List<Business_Detail> list = new ArrayList<>();
		Iterable<Business_Detail> customers = business_detailRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long business_detailId) {
		business_detailRepository.deleteById(business_detailId);

	}

	@Override
	public Business_Detail save(@Valid Business_Detail business_detail) {
		// TODO Auto-generated method stub
		return business_detailRepository.save(business_detail);
	}
}
