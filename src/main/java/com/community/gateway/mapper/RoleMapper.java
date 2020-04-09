package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.RoleDTO;
import com.community.gateway.model.Role;
@Mapper(componentModel = "spring")
public interface RoleMapper {
	RoleDTO toRoleDTO(Role role);

    List<RoleDTO> toRoleDTOs(List<Role> role);

    Role toRole(RoleDTO roleDTO);
}
