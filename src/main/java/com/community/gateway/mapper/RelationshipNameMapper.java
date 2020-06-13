package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.RelationshipNameDTO;
import com.community.gateway.model.RelationshipName;
@Mapper(componentModel = "spring")
public interface RelationshipNameMapper {
	RelationshipNameDTO toRelationshipNameDTO(RelationshipName relationshipname);

    List<RelationshipNameDTO> toRelationshipNameDTOs(List<RelationshipName> relationshipname);

    RelationshipName toRelationshipName(RelationshipNameDTO relationshipnameDTO);
}