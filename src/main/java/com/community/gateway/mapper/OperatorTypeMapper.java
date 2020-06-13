package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.model.OperatorType;
@Mapper(componentModel = "spring")
public interface OperatorTypeMapper {
	OperatorTypeDTO toOperatorTypeDTO(OperatorType operatorType);

    List<OperatorTypeDTO> toOperatorTypeDTOs(List<OperatorType> operatorType);

    OperatorType toOperatorType(OperatorTypeDTO operatorTypepDTO);
}