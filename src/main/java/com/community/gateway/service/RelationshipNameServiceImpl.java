package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.RelationShipName;
import com.community.gateway.model.repo.RelationshipNameRepository;

@Service
public class RelationshipNameServiceImpl implements RelationshipNameService {

	@Autowired
	RelationshipNameRepository relationshipNameRepository;
	
	@Override
	public RelationShipName findById(Long relationshipnameId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		RelationShipName relationshipname = relationshipNameRepository.findById(relationshipnameId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + relationshipnameId));
		return relationshipname;
	}

	@Override
	public List<RelationShipName> findAll() {
		List<RelationShipName> list = new ArrayList<>();
		Iterable<RelationShipName> customers = relationshipNameRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long relationshipnameId) {
		relationshipNameRepository.deleteById(relationshipnameId);

	}

	@Override
	public RelationShipName save(@Valid RelationShipName relationshipname) {
		// TODO Auto-generated method stub
		return relationshipNameRepository.save(relationshipname);
	}
}