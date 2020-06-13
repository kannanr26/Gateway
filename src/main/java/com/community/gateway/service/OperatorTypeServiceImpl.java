package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.OperatorType;
import com.community.gateway.model.repo.OperatorTypeRepository;

@Service
public class OperatorTypeServiceImpl implements OperatorTypeService {

	@Autowired
	OperatorTypeRepository operatorTypeRepository;

	@Override
	public OperatorType findById(Long operatorTypeId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		OperatorType operatorTypeNew = operatorTypeRepository.findById(operatorTypeId)
				.orElseThrow(() -> new ResourceNotFoundException("DataUpdator not found for this id :: " + operatorTypeId));
		return operatorTypeNew;
	}

	@Override
	public List<OperatorType> findAll() {
		List<OperatorType> list = new ArrayList<>();
		Iterable<OperatorType> customers = operatorTypeRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long operatorTypeId) {
		operatorTypeRepository.deleteById(operatorTypeId);

	}

	@Override
	public OperatorType save(@Valid OperatorType operatorType) {
		// TODO Auto-generated method stub
		System.out.println(" operatorType :"+operatorType.getOperatorTypeName());
		return operatorTypeRepository.save(operatorType);
	}
}