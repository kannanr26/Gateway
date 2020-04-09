package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.DepartmentDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface DepartmentLogical {

	List<DepartmentDTO> findAll();

	DepartmentDTO findById(Long departmentId)throws ResourceNotFoundException;

	//DepartmentDTO save(@Valid Department departmentDTO);

	void delete(Long departmentId) throws ResourceNotFoundException;

	DepartmentDTO save(@Valid DepartmentDTO departmentDto);

}
