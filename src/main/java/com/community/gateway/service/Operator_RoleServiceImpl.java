package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Operator_Role;
import com.community.gateway.model.repo.Operator_RoleRepository;

@Service
public class Operator_RoleServiceImpl implements Operator_RoleService {

	@Autowired
	Operator_RoleRepository operator_roleRepository;

	@Override
	public Operator_Role findById(Long operator_roleId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Operator_Role operator_role = operator_roleRepository.findById(operator_roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + operator_roleId));
		return operator_role;
	}

	@Override
	public List<Operator_Role> findAll() {
		List<Operator_Role> list = new ArrayList<>();
		Iterable<Operator_Role> customers = operator_roleRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long operator_roleId) {
		operator_roleRepository.deleteById(operator_roleId);

	}

	@Override
	public Operator_Role save(@Valid Operator_Role operator_role) {
		// TODO Auto-generated method stub
		return operator_roleRepository.save(operator_role);
	}
}
