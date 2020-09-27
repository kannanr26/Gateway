package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.City;
import com.community.gateway.model.District;
import com.community.gateway.model.State;
import com.community.gateway.model.repo.CityRepository;
import com.community.gateway.model.repoHelper.QueryHelper;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;

	
	@Override
	public City findById(Long cityId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + cityId));
		return city;
	}

	@Override
	public List<City> findAll() {
		List<City> list = new ArrayList<>();
		Iterable<City> cities = cityRepository.findAll();
		cities.forEach(list::add);
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

	@Override
	public List<City> findByDistrict(District district) {
		
		List<City> list = new ArrayList<>();
		//System.out.println("districtId"+districtId);
		Iterable<City> customers = cityRepository.findAllByDistrict(district);

		customers.forEach(list::add);
		return list;

	}

	@Override
	public List<Long> getPincode() {
		// TODO Auto-generated method stub
		return null;
	}
}
