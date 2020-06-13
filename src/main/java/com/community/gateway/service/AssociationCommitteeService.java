package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.AssociationCommittee;

public interface AssociationCommitteeService {

	AssociationCommittee findById(Long associationCommitteeId) throws ResourceNotFoundException;

	List<AssociationCommittee> findAll();

	void delete(Long associationCommitteeId);

	AssociationCommittee save(@Valid AssociationCommittee associationCommittee);
}