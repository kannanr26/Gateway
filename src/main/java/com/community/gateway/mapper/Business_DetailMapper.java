package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.Business_DetailDTO;
import com.community.gateway.model.Business_Detail;
@Mapper(componentModel = "spring")
public interface Business_DetailMapper {
	Business_DetailDTO toBusiness_DetailDTO(Business_Detail business_detail);

	List<Business_DetailDTO> toBusiness_DetailDTOs(List<Business_Detail> business_detail);

	Business_Detail toBusiness_Detail(Business_DetailDTO business_detailDTO);
}
