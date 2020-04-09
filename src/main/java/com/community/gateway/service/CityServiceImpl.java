package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.City;
import com.community.gateway.model.repo.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;

	@Override
	public City findById(Long cityId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + cityId));
		return city;
	}

	@Override
	public List<City> findAll() {
		List<City> list = new ArrayList<>();
		Iterable<City> customers = cityRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long cityId) {
		cityRepository.deleteById(cityId);

	}

	@Override
	public City save(@Valid City city) {
		// TODO Auto-generated method stub
		return cityRepository.save(city);
	}
}
