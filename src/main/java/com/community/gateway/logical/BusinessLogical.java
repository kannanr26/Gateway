package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface BusinessLogical {

	List<BusinessDTO> findAll();

	BusinessDTO findById(Long businessId)throws ResourceNotFoundException;

	//BusinessDTO save(@Valid Business businessDTO);

	void delete(Long businessId) throws ResourceNotFoundException;

	BusinessDTO save(@Valid BusinessDTO businessDto);

}
