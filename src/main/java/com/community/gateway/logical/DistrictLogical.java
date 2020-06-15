package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface DistrictLogical {

	List<DistrictDTO> findAll();

	DistrictDTO findById(Long districtId) throws ResourceNotFoundException;

	void delete(Long districtId) throws ResourceNotFoundException;

	DistrictDTO save(@Valid DistrictDTO districtDto);

	List<DistrictDTO> findAllByStateId(Long stateId);

}