package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.DepartmentDTO;
import com.community.gateway.model.Department;
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	DepartmentDTO toDepartmentDTO(Department department);

    List<DepartmentDTO> toDepartmentDTOs(List<Department> department);

    Department toDepartment(DepartmentDTO departmentDTO);
}
