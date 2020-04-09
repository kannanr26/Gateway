package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.RelationShipsDTO;
import com.community.gateway.model.RelationShips;
@Mapper(componentModel = "spring")
public interface RelationShipsMapper {
	RelationShipsDTO toRelationShipsDTO(RelationShips relationships);

    List<RelationShipsDTO> toRelationShipsDTOs(List<RelationShips> relationships);

    RelationShips toRelationShips(RelationShipsDTO relationshipsDTO);
}
