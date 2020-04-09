package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Operator_LoginDetails;
import com.community.gateway.model.repo.Operator_LoginDetailsRepository;

@Service
public class Operator_LoginDetailsServiceImpl implements Operator_LoginDetailsService {

	@Autowired
	Operator_LoginDetailsRepository operator_logindetailsRepository;

	@Override
	public Operator_LoginDetails findById(Long operator_logindetailsId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Operator_LoginDetails operator_logindetails = operator_logindetailsRepository.findById(operator_logindetailsId).orElseThrow(
				() -> new ResourceNotFoundException("Operator not found for this id :: " + operator_logindetailsId));
		return operator_logindetails;
	}

	@Override
	public List<Operator_LoginDetails> findAll() {
		List<Operator_LoginDetails> list = new ArrayList<>();
		Iterable<Operator_LoginDetails> customers = operator_logindetailsRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long operator_logindetailsId) {
		operator_logindetailsRepository.deleteById(operator_logindetailsId);

	}

	@Override
	public Operator_LoginDetails save(@Valid Operator_LoginDetails operator_logindetails) {
		// TODO Auto-generated method stub
		return operator_logindetailsRepository.save(operator_logindetails);
	}
}
