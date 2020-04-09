package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.Education_DetailDTO;
import com.community.gateway.model.Education_Detail;
@Mapper(componentModel = "spring")
public interface Education_DetailMapper {
	Education_DetailDTO toEducation_DetailDTO(Education_Detail education_detail);

	List<Education_DetailDTO> toEducation_DetailDTOs(List<Education_Detail> education_detail);

	Education_Detail toEducation_Detail(Education_DetailDTO education_detailDTO);
}
