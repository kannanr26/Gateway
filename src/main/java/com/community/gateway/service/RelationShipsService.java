package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.RelationShips;

public interface RelationShipsService {

	RelationShips findById(Long relationshipsId) throws ResourceNotFoundException;

	List<RelationShips> findAll();

	void delete(Long relationshipsId);

	RelationShips save(@Valid RelationShips relationships);
}
