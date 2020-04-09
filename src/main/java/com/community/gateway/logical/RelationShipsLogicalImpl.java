package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.RelationShipsDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.RelationShipsMapper;
import com.community.gateway.model.RelationShips;
import com.community.gateway.service.RelationShipsService;

@Service
public class RelationShipsLogicalImpl implements RelationShipsLogical {

	@Autowired
	RelationShipsService relationshipsService;
	
	@Autowired
	RelationShipsMapper relationshipsMapper;

	@Override
	public List<RelationShipsDTO> findAll() {
		// TODO Auto-generated method stub
		return relationshipsMapper.toRelationShipsDTOs(relationshipsService.findAll());
	}

	@Override
	public RelationShipsDTO findById(Long relationshipsId) throws ResourceNotFoundException {
		return relationshipsMapper.toRelationShipsDTO(relationshipsService.findById(relationshipsId));
	}

	@Override
	public RelationShipsDTO save(@Valid RelationShipsDTO relationshipsDto) {
		// TODO Auto-generated method stub
		return relationshipsMapper.toRelationShipsDTO(relationshipsService.save(relationshipsMapper.toRelationShips(relationshipsDto)));
		
	}

	@Override
	public void delete(Long relationshipsId)throws ResourceNotFoundException {
		relationshipsService.delete(relationshipsId);

	}

}
