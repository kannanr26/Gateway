package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Department;
import com.community.gateway.model.repo.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department findById(Long departmentId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + departmentId));
		return department;
	}

	@Override
	public List<Department> findAll() {
		List<Department> list = new ArrayList<>();
		Iterable<Department> customers = departmentRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long departmentId) {
		departmentRepository.deleteById(departmentId);

	}

	@Override
	public Department save(@Valid Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}
}
