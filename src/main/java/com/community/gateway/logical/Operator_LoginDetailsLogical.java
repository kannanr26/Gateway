package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.Operator_LoginDetailsDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface Operator_LoginDetailsLogical {

	List<Operator_LoginDetailsDTO> findAll();

	Operator_LoginDetailsDTO findById(Long operator_logindetailsId)throws ResourceNotFoundException;

	//Operator_LoginDetailsDTO save(@Valid Operator_LoginDetails operator_logindetailsDTO);

	void delete(Long operator_logindetailsId) throws ResourceNotFoundException;

	Operator_LoginDetailsDTO save(@Valid Operator_LoginDetailsDTO operator_logindetailsDto);

}
