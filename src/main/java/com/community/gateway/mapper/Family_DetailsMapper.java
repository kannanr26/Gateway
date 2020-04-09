package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.community.gateway.dto.Family_DetailsDTO;
import com.community.gateway.model.Family_Details;
@Mapper(componentModel = "spring")
public interface Family_DetailsMapper {
	Family_DetailsMapper INSTANCE = Mappers.getMapper( Family_DetailsMapper.class );
	Family_DetailsDTO toFamily_DetailsDTO(Family_Details family_details);

    List<Family_DetailsDTO> toFamily_DetailsDTOs(List<Family_Details> family_details);

    Family_Details toFamily_Details(Family_DetailsDTO family_detailsDTO);
}
