package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.EducationDTO;
import com.community.gateway.model.Education;
@Mapper(componentModel = "spring")
public interface EducationMapper {
	EducationDTO toEducationDTO(Education education);

    List<EducationDTO> toEducationDTOs(List<Education> education);

    Education toEducation(EducationDTO educationDTO);
}
