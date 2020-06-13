package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.RelationshipName;

public interface RelationshipNameService {

	RelationshipName findById(Long relationshipnameId) throws ResourceNotFoundException;

	List<RelationshipName> findAll();

	void delete(Long relationshipnameId);

	RelationshipName save(@Valid RelationshipName relationshipname);
}