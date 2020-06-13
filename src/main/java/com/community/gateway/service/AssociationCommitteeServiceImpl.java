package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.AssociationCommittee;
import com.community.gateway.model.repo.AssociationCommitteeRepository;

@Service
public class AssociationCommitteeServiceImpl implements AssociationCommitteeService {

	@Autowired
	AssociationCommitteeRepository associationCommitteeRepository;

	@Override
	public AssociationCommittee findById(Long associationCommitteeId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		AssociationCommittee associationCommittee = associationCommitteeRepository.findById(associationCommitteeId)
				.orElseThrow(() -> new ResourceNotFoundException("AssociationCommittee not found for this id :: " + associationCommitteeId));
		return associationCommittee;
	}

	@Override
	public List<AssociationCommittee> findAll() {
		List<AssociationCommittee> list = new ArrayList<>();
		Iterable<AssociationCommittee> customers = associationCommitteeRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long associationCommitteeId) {
		associationCommitteeRepository.deleteById(associationCommitteeId);

	}

	@Override
	public AssociationCommittee save(@Valid AssociationCommittee associationCommittee) {
		// TODO Auto-generated method stub
		System.out.println(" associationCommittee :"+associationCommittee.getAssociationCommitteeName());
		return associationCommitteeRepository.save(associationCommittee);
	}
}