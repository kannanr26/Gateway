package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.MaritalStatusDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.MaritalStatusMapper;
import com.community.gateway.service.MaritalStatusService;

@Service
public class MaritalStatusLogicalImpl implements MaritalStatusLogical {

	@Autowired
	MaritalStatusService maritalStatusService;
	
	@Autowired
	MaritalStatusMapper maritalStatusMapper;

	@Override
	public List<MaritalStatusDTO> findAll() {
		// TODO Auto-generated method stub
		return maritalStatusMapper.toMaritalStatusDTOs(maritalStatusService.findAll());
	}

	@Override
	public MaritalStatusDTO findById(Long maritalStatusId) throws ResourceNotFoundException {
		return maritalStatusMapper.toMaritalStatusDTO(maritalStatusService.findById(maritalStatusId));
	}

	@Override
	public MaritalStatusDTO save(@Valid MaritalStatusDTO maritalStatusDto) {
		// TODO Auto-generated method stub
		System.out.println(" maritalStatusDto :"+maritalStatusDto.getMaritalStatusName());
		return maritalStatusMapper.toMaritalStatusDTO(maritalStatusService.save(maritalStatusMapper.toMaritalStatus(maritalStatusDto)));
		
	}

	@Override
	public void delete(Long maritalStatusId)throws ResourceNotFoundException {
		maritalStatusService.delete(maritalStatusId);

	}

}