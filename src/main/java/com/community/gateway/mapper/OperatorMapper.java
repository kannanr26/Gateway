package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.model.Operator;
@Mapper(componentModel = "spring")

public interface OperatorMapper {
	OperatorMapper INSTANCE = Mappers.getMapper( OperatorMapper.class );
	OperatorDTO toOperatorsDTO(Operator operator);

	List<OperatorDTO> toOperatorsDTOs(List<Operator> operator);

	Operator toOperator(OperatorDTO operatorDto);
}
