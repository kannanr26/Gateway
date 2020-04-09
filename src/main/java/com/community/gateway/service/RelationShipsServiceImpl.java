package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.RelationShips;
import com.community.gateway.model.repo.RelationShipsRepository;

@Service
public class RelationShipsServiceImpl implements RelationShipsService {

	@Autowired
	RelationShipsRepository relationshipsRepository;

	@Override
	public RelationShips findById(Long relationshipsId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		RelationShips relationships = relationshipsRepository.findById(relationshipsId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + relationshipsId));
		return relationships;
	}

	@Override
	public List<RelationShips> findAll() {
		List<RelationShips> list = new ArrayList<>();
		Iterable<RelationShips> customers = relationshipsRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long relationshipsId) {
		relationshipsRepository.deleteById(relationshipsId);

	}

	@Override
	public RelationShips save(@Valid RelationShips relationships) {
		// TODO Auto-generated method stub
		return relationshipsRepository.save(relationships);
	}
}
