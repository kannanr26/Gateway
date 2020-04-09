package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.Operator_RoleDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.Operator_RoleMapper;
import com.community.gateway.model.Operator_Role;
import com.community.gateway.service.Operator_RoleService;

@Service
public class Operator_RoleLogicalImpl implements Operator_RoleLogical {

	@Autowired
	Operator_RoleService operator_roleService;
	
	@Autowired
	Operator_RoleMapper operator_roleMapper;

	@Override
	public List<Operator_RoleDTO> findAll() {
		// TODO Auto-generated method stub
		return operator_roleMapper.toOperator_RoleDTOs(operator_roleService.findAll());
	}

	@Override
	public Operator_RoleDTO findById(Long operator_roleId) throws ResourceNotFoundException {
		return operator_roleMapper.toOperator_RoleDTO(operator_roleService.findById(operator_roleId));
	}

	@Override
	public Operator_RoleDTO save(@Valid Operator_RoleDTO operator_roleDto) {
		// TODO Auto-generated method stub
		return operator_roleMapper.toOperator_RoleDTO(operator_roleService.save(operator_roleMapper.toOperator_Role(operator_roleDto)));
		
	}

	@Override
	public void delete(Long operator_roleId)throws ResourceNotFoundException {
		operator_roleService.delete(operator_roleId);

	}

}
