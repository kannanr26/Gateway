package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.RelationShipNameDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.RelationshipNameMapper;
import com.community.gateway.model.RelationShipName;
import com.community.gateway.service.RelationshipNameService;

@Service
public class RelationShipNameLogicalImpl implements RelationshipNameLogical {

	@Autowired
	RelationshipNameService relationshipNameService;
	
	@Autowired
	RelationshipNameMapper relationshipNameMapper;
	

	@Override
	public List<RelationShipNameDTO> findAll() {
		// TODO Auto-generated method stub
		return relationshipNameMapper.toRelationshipNameDTOs(relationshipNameService.findAll());
	}

	@Override
	public RelationShipNameDTO findById(Long relationshipnameId) throws ResourceNotFoundException {
		return relationshipNameMapper.toRelationshipNameDTO(relationshipNameService.findById(relationshipnameId));
	}

	@Override
	public RelationShipNameDTO save(@Valid RelationShipNameDTO relationshipnameDto) {
		// TODO Auto-generated method stub
		return relationshipNameMapper.toRelationshipNameDTO(relationshipNameService.save(relationshipNameMapper.toRelationshipName(relationshipnameDto)));
		
	}

	@Override
	public void delete(Long relationshipNameId)throws ResourceNotFoundException {
		relationshipNameService.delete(relationshipNameId);

	}

}