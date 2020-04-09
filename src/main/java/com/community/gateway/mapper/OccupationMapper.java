package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.OccupationDTO;
import com.community.gateway.model.Occupation;

@Mapper(componentModel = "spring")
public interface OccupationMapper {
	OccupationDTO toOccupationDTO(Occupation occupation);

	List<OccupationDTO> toOccupationDTOs(List<Occupation> occupation);

	Occupation toOccupation(OccupationDTO occupationDTO);
}
