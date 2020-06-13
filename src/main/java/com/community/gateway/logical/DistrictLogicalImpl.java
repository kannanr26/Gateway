package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.DistrictMapper;
import com.community.gateway.service.DistrictService;

@Service
public class DistrictLogicalImpl implements DistrictLogical {

	@Autowired
	DistrictService districtService;
	
	@Autowired
	DistrictMapper districtMapper;

	@Override
	public List<DistrictDTO> findAll() {
		// TODO Auto-generated method stub
		return districtMapper.toDistrictDTOs(districtService.findAll());
	}

	@Override
	public DistrictDTO findById(Long districtId) throws ResourceNotFoundException {
		return districtMapper.toDistrictDTO(districtService.findById(districtId));
	}

	@Override
	public DistrictDTO save(@Valid DistrictDTO districtDto) {
		// TODO Auto-generated method stub
		System.out.println(" districtDto :"+districtDto.getDistrictName());
		return districtMapper.toDistrictDTO(districtService.save(districtMapper.toDistrict(districtDto)));
		
	}

	@Override
	public void delete(Long districtId)throws ResourceNotFoundException {
		districtService.delete(districtId);

	}

}