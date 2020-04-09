package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.Operator_RoleDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface Operator_RoleLogical {

	List<Operator_RoleDTO> findAll();

	Operator_RoleDTO findById(Long operator_roleId)throws ResourceNotFoundException;

	//Operator_RoleDTO save(@Valid Operator_Role operator_roleDTO);

	void delete(Long operator_roleId) throws ResourceNotFoundException;

	Operator_RoleDTO save(@Valid Operator_RoleDTO operator_roleDto);

}
