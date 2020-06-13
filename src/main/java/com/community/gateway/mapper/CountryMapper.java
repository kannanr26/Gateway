package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.CountryDTO;
import com.community.gateway.model.Country;
@Mapper(componentModel = "spring")
public interface CountryMapper {
	CountryDTO toCountryDTO(Country country);

    List<CountryDTO> toCountryDTOs(List<Country> country);

    Country toCountry(CountryDTO countryDTO);
}