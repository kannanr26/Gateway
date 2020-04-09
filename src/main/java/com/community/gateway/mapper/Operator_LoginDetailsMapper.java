package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.Operator_LoginDetailsDTO;
import com.community.gateway.model.Operator_LoginDetails;
@Mapper(componentModel = "spring")
public interface Operator_LoginDetailsMapper {
	Operator_LoginDetailsDTO toOperator_LoginDetailsDTO(Operator_LoginDetails operator_logindetails);

    List<Operator_LoginDetailsDTO> toOperator_LoginDetailsDTOs(List<Operator_LoginDetails> operator_logindetails);

    Operator_LoginDetails toOperator_LoginDetails(Operator_LoginDetailsDTO operator_logindetailsDTO);
}
