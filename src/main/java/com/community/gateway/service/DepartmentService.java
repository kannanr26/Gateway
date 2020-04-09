package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Department;

public interface DepartmentService {
	Department findById(Long departmentId) throws ResourceNotFoundException;

	List<Department> findAll();

	void delete(Long departmentId);

	Department save(@Valid Department department);
}
