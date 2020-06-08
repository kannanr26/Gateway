package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.model.BloodGroup;
@Mapper(componentModel = "spring")
public interface BloodGroupMapper {
	BloodGroupDTO toBloodGroupDTO(BloodGroup bloodGroup);

    List<BloodGroupDTO> toBloodGroupDTOs(List<BloodGroup> bloodGroup);

    BloodGroup toBloodGroup(BloodGroupDTO bloodGroupDTO);
}