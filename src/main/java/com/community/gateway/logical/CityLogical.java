package com.community.gateway.logical;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface CityLogical {

	Map<Integer, String> findAll() ;

	CityDTO findById(Long cityId)throws ResourceNotFoundException;
	//CityDTO findByName(String cityName)throws ResourceNotFoundException;

	//CityDTO save(@Valid City cityDTO);

	void deleteCity(Long cityId) throws ResourceNotFoundException;

	void addCity(@Valid CityDTO cityDto);

}
