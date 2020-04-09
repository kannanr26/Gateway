package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.RoleDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface RoleLogical {

	List<RoleDTO> findAll();

	RoleDTO findById(Long roleId)throws ResourceNotFoundException;

	//RoleDTO save(@Valid Role roleDTO);

	void delete(Long roleId) throws ResourceNotFoundException;

	RoleDTO save(@Valid RoleDTO roleDto);

}
