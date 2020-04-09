package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Operator_Role;

public interface Operator_RoleService {

	Operator_Role findById(Long operator_roleId) throws ResourceNotFoundException;

	List<Operator_Role> findAll();

	void delete(Long operator_roleId);

	Operator_Role save(@Valid Operator_Role operator_role);
}
