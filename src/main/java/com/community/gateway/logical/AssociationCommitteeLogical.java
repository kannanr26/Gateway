package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.AssociationCommitteeDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface AssociationCommitteeLogical {

	List<AssociationCommitteeDTO> findAll();

	AssociationCommitteeDTO findById(Long associationCommitteeId)throws ResourceNotFoundException;

	void delete(Long associationCommitteeId) throws ResourceNotFoundException;

	AssociationCommitteeDTO save(@Valid AssociationCommitteeDTO associationCommitteeDto);

}