package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CountryDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.CountryMapper;
import com.community.gateway.service.CountryService;

@Service
public class CountryLogicalImpl implements CountryLogical {

	@Autowired
	CountryService countryService;
	
	@Autowired
	CountryMapper countryMapper;

	@Override
	public List<CountryDTO> findAll() {
		// TODO Auto-generated method stub
		return countryMapper.toCountryDTOs(countryService.findAll());
	}

	@Override
	public CountryDTO findById(Long countryId) throws ResourceNotFoundException {
		return countryMapper.toCountryDTO(countryService.findById(countryId));
	}

	@Override
	public CountryDTO save(@Valid CountryDTO countryDto) {
		// TODO Auto-generated method stub
		System.out.println(" countryDto :"+countryDto.getCountryName());
		return countryMapper.toCountryDTO(countryService.save(countryMapper.toCountry(countryDto)));
		
	}

	@Override
	public void delete(Long countryId)throws ResourceNotFoundException {
		countryService.delete(countryId);

	}

}