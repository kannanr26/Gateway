package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.PermissionDTO;
import com.community.gateway.model.Permission;
@Mapper(componentModel = "spring")
public interface PermissionMapper {
	PermissionDTO toPermissionDTO(Permission permission);

    List<PermissionDTO> toPermissionDTOs(List<Permission> permission);

    Permission toPermission(PermissionDTO permissionDTO);
}