package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface BloodGroupLogical {

	List<BloodGroupDTO> findAll();

	BloodGroupDTO findById(Long bloodgroupId)throws ResourceNotFoundException;

	//KulamDTO save(@Valid Bloodgroup bloodgroupDTO);

	void delete(Long bloodgroupId) throws ResourceNotFoundException;

	BloodGroupDTO save(@Valid BloodGroupDTO bloodgroupDto);

}