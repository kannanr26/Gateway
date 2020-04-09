package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Role;

public interface RoleService {
	Role findById(Long roleId) throws ResourceNotFoundException;

	List<Role> findAll();

	void delete(Long roleId);

	Role save(@Valid Role role);
}
