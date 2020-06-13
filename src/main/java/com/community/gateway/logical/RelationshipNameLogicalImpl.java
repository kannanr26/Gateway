package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.RelationshipNameDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.RelationshipNameMapper;
import com.community.gateway.model.RelationshipName;
import com.community.gateway.service.RelationshipNameService;

@Service
public class RelationshipNameLogicalImpl implements RelationshipNameLogical {

	@Autowired
	RelationshipNameService relationshipNameService;
	
	@Autowired
	RelationshipNameMapper relationshipNameMapper;
	

	@Override
	public List<RelationshipNameDTO> findAll() {
		// TODO Auto-generated method stub
		return relationshipNameMapper.toRelationshipNameDTOs(relationshipNameService.findAll());
	}

	@Override
	public RelationshipNameDTO findById(Long relationshipnameId) throws ResourceNotFoundException {
		return relationshipNameMapper.toRelationshipNameDTO(relationshipNameService.findById(relationshipnameId));
	}

	@Override
	public RelationshipNameDTO save(@Valid RelationshipNameDTO relationshipnameDto) {
		// TODO Auto-generated method stub
		return relationshipNameMapper.toRelationshipNameDTO(relationshipNameService.save(relationshipNameMapper.toRelationshipName(relationshipnameDto)));
		
	}

	@Override
	public void delete(Long relationshipNameId)throws ResourceNotFoundException {
		relationshipNameService.delete(relationshipNameId);

	}

}