package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.MaritalStatus;
import com.community.gateway.model.repo.MaritalStatusRepository;

@Service
public class MaritalStatusServiceImpl implements MaritalStatusService {

	@Autowired
	MaritalStatusRepository maritalStatusRepository;

	@Override
	public MaritalStatus findById(Long maritalStatusId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		MaritalStatus maritalStatus = maritalStatusRepository.findById(maritalStatusId)
				.orElseThrow(() -> new ResourceNotFoundException("Blood not found for this id :: " + maritalStatusId));
		return maritalStatus;
	}

	@Override
	public List<MaritalStatus> findAll() {
		List<MaritalStatus> list = new ArrayList<>();
		Iterable<MaritalStatus> customers = maritalStatusRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long maritalStatusId) {
		maritalStatusRepository.deleteById(maritalStatusId);

	}

	@Override
	public MaritalStatus save(@Valid MaritalStatus maritalStatus) {
		// TODO Auto-generated method stub
		System.out.println(" maritalStatus :"+maritalStatus.getMaritalStatusName());
		return maritalStatusRepository.save(maritalStatus);
	}
}