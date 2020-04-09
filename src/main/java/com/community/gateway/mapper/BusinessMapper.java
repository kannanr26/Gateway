package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.model.Business;
@Mapper(componentModel = "spring")
public interface BusinessMapper {
	BusinessDTO toBusinessDTO(Business business);

	List<BusinessDTO> toBusinessDTOs(List<Business> business);

	Business toBusiness(BusinessDTO businessDTO);
}
