package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface OperatorTypeLogical {

	List<OperatorTypeDTO> findAll();

	OperatorTypeDTO findById(Long operatorTypeId)throws ResourceNotFoundException;

	void delete(Long operatorTypeId) throws ResourceNotFoundException;

	OperatorTypeDTO save(@Valid OperatorTypeDTO operatorTypeDto);

}