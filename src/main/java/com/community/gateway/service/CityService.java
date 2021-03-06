package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.City;

public interface CityService {

	City findById(Long cityId) throws ResourceNotFoundException;

	List<City> findAll();

	void delete(Long cityId);

	City save(@Valid City city);
}
