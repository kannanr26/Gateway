package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.StateDTO;
import com.community.gateway.model.State;
@Mapper(componentModel = "spring")
public interface StateMapper {
	StateDTO toStateDTO(State state);

    List<StateDTO> toStateDTOs(List<State> state);

    State toState(StateDTO stateDTO);
}