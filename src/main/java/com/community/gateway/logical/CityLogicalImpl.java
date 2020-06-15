package com.community.gateway.logical;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.CityMapper;
import com.community.gateway.service.CityService;

@Service
public class CityLogicalImpl implements CityLogical {

	@Autowired
	CityService cityService;

	@Autowired
	CityMapper cityMapper;

	@Override
	public CityDTO findById(Long cityId) throws ResourceNotFoundException {
		return cityMapper.toCityDTO(cityService.findById(cityId));
	}

	@Override
	public CityDTO save(CityDTO cityDto) {
		// TODO Auto-generated method stub
		System.out.println(" cityDto :"+cityDto.getDistrictId());
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
	public List<CityDTO>  findByDistrictId(long districtId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return cityMapper.toCityDTOs(cityService.findByDistrictId(districtId));
	}

}
