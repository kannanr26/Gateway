package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Role;
import com.community.gateway.model.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role findById(Long roleId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + roleId));
		return role;
	}

	@Override
	public List<Role> findAll() {
		List<Role> list = new ArrayList<>();
		Iterable<Role> customers = roleRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long roleId) {
		roleRepository.deleteById(roleId);

	}

	@Override
	public Role save(@Valid Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}
}
