package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.PermissionDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.PermissionMapper;
import com.community.gateway.service.PermissionService;

@Service
public class PermissionLogicalImpl implements PermissionLogical {

	@Autowired
	PermissionService permissionService;
	
	@Autowired
	PermissionMapper permissionMapper;

	@Override
	public List<PermissionDTO> findAll() {
		// TODO Auto-generated method stub
		return permissionMapper.toPermissionDTOs(permissionService.findAll());
	}

	@Override
	public PermissionDTO findById(Long permissionId) throws ResourceNotFoundException {
		return permissionMapper.toPermissionDTO(permissionService.findById(permissionId));
	}

	@Override
	public PermissionDTO save(@Valid PermissionDTO permissionDto) {
		// TODO Auto-generated method stub
		System.out.println(" permissionDto :"+permissionDto.getPermissionName());
		return permissionMapper.toPermissionDTO(permissionService.save(permissionMapper.toPermission(permissionDto)));
		
	}

	@Override
	public void delete(Long permissionId)throws ResourceNotFoundException {
		permissionService.delete(permissionId);

	}

}