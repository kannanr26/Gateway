package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.RelationShipNameDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface RelationshipNameLogical {

	List<RelationShipNameDTO> findAll();

	RelationShipNameDTO findById(Long relationshipnameId)throws ResourceNotFoundException;

	//RelationshipNameDTO save(@Valid RelationshipName relationshipnameDTO);

	void delete(Long relationshipnameId) throws ResourceNotFoundException;

	RelationShipNameDTO save(@Valid RelationShipNameDTO relationshipnameDto);

}