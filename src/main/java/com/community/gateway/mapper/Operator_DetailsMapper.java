package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.Operator_DetailsDTO;
import com.community.gateway.model.Operator_Details;
@Mapper(componentModel = "spring")
public interface Operator_DetailsMapper {
	Operator_DetailsDTO toOperator_LoginDetailsDTO(Operator_Details operator_Details);

    List<Operator_DetailsDTO> toOperator_LoginDetailsDTOs(List<Operator_Details> operator_Details);

    Operator_Details toOperator_LoginDetails(Operator_DetailsDTO operator_DetailsDTO);
}
