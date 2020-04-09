package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.DeityDTO;
import com.community.gateway.model.Deity;
@Mapper(componentModel = "spring")
public interface DeityMapper {
	DeityDTO toDeityDTO(Deity deity);

    List<DeityDTO> toDeityDTOs(List<Deity> deity);

    Deity toDeity(DeityDTO deityDTO);
}
