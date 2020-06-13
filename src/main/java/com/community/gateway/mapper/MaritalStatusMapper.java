package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.MaritalStatusDTO;
import com.community.gateway.model.MaritalStatus;
@Mapper(componentModel = "spring")
public interface MaritalStatusMapper {
	MaritalStatusDTO toMaritalStatusDTO(MaritalStatus maritalStatus);

    List<MaritalStatusDTO> toMaritalStatusDTOs(List<MaritalStatus> maritalStatus);

    MaritalStatus toMaritalStatus(MaritalStatusDTO maritalStatusDTO);
}