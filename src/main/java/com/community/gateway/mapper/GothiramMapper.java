package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.model.Gothiram;
@Mapper(componentModel = "spring")
public interface GothiramMapper {
	GothiramDTO toGothiramDTO(Gothiram gothiram);

    List<GothiramDTO> toGothiramDTOs(List<Gothiram> gothiram);

    Gothiram toGothiram(GothiramDTO gothiramDTO);
}
