package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.DepartmentDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.DepartmentMapper;
import com.community.gateway.model.Department;
import com.community.gateway.service.DepartmentService;

@Service
public class DepartmentLogicalImpl implements DepartmentLogical {

	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DepartmentMapper departmentMapper;

	@Override
	public List<DepartmentDTO> findAll() {
		// TODO Auto-generated method stub
		return departmentMapper.toDepartmentDTOs(departmentService.findAll());
	}

	@Override
	public DepartmentDTO findById(Long departmentId) throws ResourceNotFoundException {
		return departmentMapper.toDepartmentDTO(departmentService.findById(departmentId));
	}

	@Override
	public DepartmentDTO save(@Valid DepartmentDTO departmentDto) {
		// TODO Auto-generated method stub
		return departmentMapper.toDepartmentDTO(departmentService.save(departmentMapper.toDepartment(departmentDto)));
		
	}

	@Override
	public void delete(Long departmentId)throws ResourceNotFoundException {
		departmentService.delete(departmentId);

	}

}
