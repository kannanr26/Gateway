package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.CasteDTO;
import com.community.gateway.model.Caste;
@Mapper(componentModel = "spring")
public interface CasteMapper {
	CasteDTO toCasteDTO(Caste caste);

	List<CasteDTO> toCasteDTOs(List<Caste> caste);

	Caste toCaste(CasteDTO casteDTO);
}
