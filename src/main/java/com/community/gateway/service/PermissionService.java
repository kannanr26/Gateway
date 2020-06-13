package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Permission;

public interface PermissionService {

	Permission findById(Long permissionId) throws ResourceNotFoundException;

	List<Permission> findAll();

	void delete(Long permissionId);

	Permission save(@Valid Permission permission);
}