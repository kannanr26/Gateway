package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.Occupation_DetailDTO;
import com.community.gateway.model.Occupation_Detail;

@Mapper(componentModel = "spring")
public interface Occupation_DetailMapper {
	Occupation_DetailDTO toOccupation_DetailDTO(Occupation_Detail occupation_detail);

	List<Occupation_DetailDTO> toOccupation_DetailDTOs(List<Occupation_Detail> occupation_detail);

	Occupation_Detail toOccupation_Detail(Occupation_DetailDTO occupation_detailDTO);
}
