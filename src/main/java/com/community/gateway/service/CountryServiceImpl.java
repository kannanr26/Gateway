package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Country;
import com.community.gateway.model.repo.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public Country findById(Long countryId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Country country = countryRepository.findById(countryId)
				.orElseThrow(() -> new ResourceNotFoundException("Blood not found for this id :: " + countryId));
		return country;
	}

	@Override
	public List<Country> findAll() {
		List<Country> list = new ArrayList<>();
		Iterable<Country> customers = countryRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long countryId) {
		countryRepository.deleteById(countryId);

	}

	@Override
	public Country save(@Valid Country country) {
		// TODO Auto-generated method stub
		System.out.println(" country :"+country.getCountryName());
		return countryRepository.save(country);
	}
}