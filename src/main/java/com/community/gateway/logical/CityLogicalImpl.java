package com.community.gateway.logical;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.CityMapper;
import com.community.gateway.mapper.DistrictMapper;
import com.community.gateway.service.CityService;

@Service
public class CityLogicalImpl implements CityLogical {

	@Autowired
	CityService cityService;

	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	DistrictMapper districtMapper;
	
	@Override
	public CityDTO findById(Long cityId) throws ResourceNotFoundException {
		return cityMapper.toCityDTO(cityService.findById(cityId));
	}

	@Override
	public CityDTO save(CityDTO cityDto) {
		return cityMapper.toCityDTO(cityService.save(cityMapper.toCity(cityDto)));

	}

	@Override
	public List<CityDTO> findAll() {
		return cityMapper.toCityDTOs(cityService.findAll());
	}

	@Override
	public void deleteCity(Long cityId) throws ResourceNotFoundException {
		cityService.delete(cityId);

	}

	@Override
	public List<CityDTO>  findByDistrict(DistrictDTO district) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return cityMapper.toCityDTOs(cityService.findByDistrict(districtMapper.toDistrict(district)));
	}

	@Override
	public List<Long> getPincode() {
		// TODO Auto-generated method stub
		List<CityDTO> cityList= cityMapper.toCityDTOs(cityService.findAll());
		List<Long> pin = new ArrayList<Long>(cityList.size());
		for(CityDTO city :cityList) {
			long pincode=city.getPincode();
			if(!pin.contains(pincode))
					pin.add(pincode);
		}
		return pin;
	}

}
