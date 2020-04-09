package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.Operator_RoleDTO;
import com.community.gateway.model.Operator_Role;
@Mapper(componentModel = "spring")
public interface Operator_RoleMapper {
	Operator_RoleDTO toOperator_RoleDTO(Operator_Role operator_role);

    List<Operator_RoleDTO> toOperator_RoleDTOs(List<Operator_Role> operator_role);

    Operator_Role toOperator_Role(Operator_RoleDTO operator_roleDTO);
}
