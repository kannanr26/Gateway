package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.model.District;
@Mapper(componentModel = "spring")
public interface DistrictMapper {
	DistrictDTO toDistrictDTO(District district);

    List<DistrictDTO> toDistrictDTOs(List<District> district);

    District toDistrict(DistrictDTO districtDTO);
}