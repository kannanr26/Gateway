package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.AssociationCommitteeDTO;
import com.community.gateway.model.AssociationCommittee;
@Mapper(componentModel = "spring")
public interface AssociationCommitteeMapper {
	AssociationCommitteeDTO toAssociationCommitteeDTO(AssociationCommittee associationCommittee);

    List<AssociationCommitteeDTO> toAssociationCommitteeDTOs(List<AssociationCommittee> associationCommittee);

    AssociationCommittee toAssociationCommittee(AssociationCommitteeDTO associationCommitteeDTO);
}