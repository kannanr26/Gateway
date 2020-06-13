package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.PermissionDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface PermissionLogical {

	List<PermissionDTO> findAll();

	PermissionDTO findById(Long permissionId)throws ResourceNotFoundException;

	void delete(Long permissionId) throws ResourceNotFoundException;

	PermissionDTO save(@Valid PermissionDTO permissionDto);

}