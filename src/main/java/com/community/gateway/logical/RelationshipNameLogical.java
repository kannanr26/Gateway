package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.RelationshipNameDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface RelationshipNameLogical {

	List<RelationshipNameDTO> findAll();

	RelationshipNameDTO findById(Long relationshipnameId)throws ResourceNotFoundException;

	//RelationshipNameDTO save(@Valid RelationshipName relationshipnameDTO);

	void delete(Long relationshipnameId) throws ResourceNotFoundException;

	RelationshipNameDTO save(@Valid RelationshipNameDTO relationshipnameDto);

}