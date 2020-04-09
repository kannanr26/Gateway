package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.RelationShipsDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface RelationShipsLogical {

	List<RelationShipsDTO> findAll();

	RelationShipsDTO findById(Long relationshipsId)throws ResourceNotFoundException;

	//RelationShipsDTO save(@Valid RelationShips relationshipsDTO);

	void delete(Long relationshipsId) throws ResourceNotFoundException;

	RelationShipsDTO save(@Valid RelationShipsDTO relationshipsDto);

}
