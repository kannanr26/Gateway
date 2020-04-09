package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.PersonalDetailsDTO;
import com.community.gateway.model.PersonalDetails;
@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper {
	PersonalDetailsDTO toPersonalDetailsDTO(PersonalDetails personaldetails);

    List<PersonalDetailsDTO> toPersonalDetailsDTOs(List<PersonalDetails> personaldetails);

    PersonalDetails toPersonalDetails(PersonalDetailsDTO personaldetailsDTO);
}
