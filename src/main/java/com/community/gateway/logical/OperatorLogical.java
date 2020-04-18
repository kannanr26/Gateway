package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface OperatorLogical {

	List<OperatorDTO> findAll();

	OperatorDTO findById(Long operatorId)throws ResourceNotFoundException;

	void delete(Long operatorId) throws ResourceNotFoundException;

	OperatorDTO save(@Valid OperatorDTO operatorDto);

	OperatorDTO findByMobileNumber(long mobileNumber) throws ResourceNotFoundException;
}
