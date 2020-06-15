package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.RelationShipName;

public interface RelationshipNameService {

	RelationShipName findById(Long relationshipnameId) throws ResourceNotFoundException;

	List<RelationShipName> findAll();

	void delete(Long relationshipnameId);

	RelationShipName save(@Valid RelationShipName relationshipname);
}