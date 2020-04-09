/**
 * 
 */
package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Operator;
import com.community.gateway.model.repo.OperatorRepository;

/**
 * @author deepikamalar
 *
 */
@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	OperatorRepository operatorRepository;
	@Override
	public Operator findById(Long operatorId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		Operator operator = operatorRepository.findById(operatorId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + operatorId));
		return operator;
	}

	@Override
	public List<Operator> findAll() {
		List<Operator> list = new ArrayList<>();
		Iterable<Operator> customers = operatorRepository.findAll();

		customers.forEach(list::add);
		return list;
		
	}

	@Override
	public void delete(Long operatorId) {
		operatorRepository.deleteById(operatorId);
		
	}

	@Override
	public Operator save(@Valid Operator operator) {
		// TODO Auto-generated method stub
		return operatorRepository.save(operator);
	}

	@Override
	public Operator findByMobileNumber(int mobileNumber) throws ResourceNotFoundException {
		Operator operator = operatorRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this mobileNumber :: " + mobileNumber));
		return operator;
	}

}
