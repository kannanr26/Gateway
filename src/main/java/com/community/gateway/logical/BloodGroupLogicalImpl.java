package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.BloodGroupMapper;
import com.community.gateway.service.BloodGroupService;

@Service
public class BloodGroupLogicalImpl implements BloodGroupLogical {

	@Autowired
	BloodGroupService bloodGroupService;
	
	@Autowired
	BloodGroupMapper bloodGroupMapper;

	@Override
	public List<BloodGroupDTO> findAll() {
		// TODO Auto-generated method stub
		return bloodGroupMapper.toBloodGroupDTOs(bloodGroupService.findAll());
	}

	@Override
	public BloodGroupDTO findById(Long bloodGroupId) throws ResourceNotFoundException {
		return bloodGroupMapper.toBloodGroupDTO(bloodGroupService.findById(bloodGroupId));
	}

	@Override
	public BloodGroupDTO save(@Valid BloodGroupDTO bloodGroupDto) {
		// TODO Auto-generated method stub
		System.out.println(" bloodGroupDto :"+bloodGroupDto.getBloodGroupName());
		return bloodGroupMapper.toBloodGroupDTO(bloodGroupService.save(bloodGroupMapper.toBloodGroup(bloodGroupDto)));
		
	}

	@Override
	public void delete(Long bloodGroupId)throws ResourceNotFoundException {
		bloodGroupService.delete(bloodGroupId);

	}

}