package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.RoleDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.RoleMapper;
import com.community.gateway.model.Role;
import com.community.gateway.service.RoleService;

@Service
public class RoleLogicalImpl implements RoleLogical {

	@Autowired
	RoleService roleService;
	
	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<RoleDTO> findAll() {
		// TODO Auto-generated method stub
		return roleMapper.toRoleDTOs(roleService.findAll());
	}

	@Override
	public RoleDTO findById(Long roleId) throws ResourceNotFoundException {
		return roleMapper.toRoleDTO(roleService.findById(roleId));
	}

	@Override
	public RoleDTO save(@Valid RoleDTO roleDto) {
		// TODO Auto-generated method stub
		return roleMapper.toRoleDTO(roleService.save(roleMapper.toRole(roleDto)));
		
	}

	@Override
	public void delete(Long roleId)throws ResourceNotFoundException {
		roleService.delete(roleId);

	}

}
