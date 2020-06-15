package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.RelationShipNameDTO;
import com.community.gateway.model.RelationShipName;
@Mapper(componentModel = "spring")
public interface RelationshipNameMapper {
	RelationShipNameDTO toRelationshipNameDTO(RelationShipName relationshipname);

    List<RelationShipNameDTO> toRelationshipNameDTOs(List<RelationShipName> relationshipname);

    RelationShipName toRelationshipName(RelationShipNameDTO relationshipnameDTO);
}