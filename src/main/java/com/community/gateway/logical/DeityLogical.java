package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.DeityDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface DeityLogical {

	List<DeityDTO> findAll();

	DeityDTO findById(Long deityId)throws ResourceNotFoundException;

	//DeityDTO save(@Valid Deity deityDTO);

	void delete(Long deityId) throws ResourceNotFoundException;

	DeityDTO save(@Valid DeityDTO deityDto);

	List<DeityDTO> findByCityId(Long cityId);

}
