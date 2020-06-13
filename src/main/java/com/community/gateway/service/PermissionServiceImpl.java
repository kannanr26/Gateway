package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Permission;
import com.community.gateway.model.repo.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	@Override
	public Permission findById(Long permissionId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Permission permission = permissionRepository.findById(permissionId)
				.orElseThrow(() -> new ResourceNotFoundException("Permission not found for this id :: " + permissionId));
		return permission;
	}

	@Override
	public List<Permission> findAll() {
		List<Permission> list = new ArrayList<>();
		Iterable<Permission> customers = permissionRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long permissionId) {
		permissionRepository.deleteById(permissionId);

	}

	@Override
	public Permission save(@Valid Permission permission) {
		// TODO Auto-generated method stub
		System.out.println(" permission :"+permission.getPermissionName());
		return permissionRepository.save(permission);
	}
}