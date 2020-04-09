package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.model.City;
@Mapper(componentModel = "spring")
public interface CityMapper {
	CityDTO toCityDTO(City city);

	List<CityDTO> toCityDTOs(List<City> city);

	City toCity(CityDTO cityDTO);
}
