package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.OccupationDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.OccupationMapper;
import com.community.gateway.model.Occupation;
import com.community.gateway.service.OccupationService;

@Service
public class OccupationLogicalImpl implements OccupationLogical {

	@Autowired
	OccupationService occupationService;
	
	@Autowired
	OccupationMapper occupationMapper;

	@Override
	public List<OccupationDTO> findAll() {
		// TODO Auto-generated method stub
		return occupationMapper.toOccupationDTOs(occupationService.findAll());
	}

	@Override
	public OccupationDTO findById(Long occupationId) throws ResourceNotFoundException {
		return occupationMapper.toOccupationDTO(occupationService.findById(occupationId));
	}

	@Override
	public OccupationDTO save(@Valid OccupationDTO occupationDto) {
		// TODO Auto-generated method stub
		return occupationMapper.toOccupationDTO(occupationService.save(occupationMapper.toOccupation(occupationDto)));
		
	}

	@Override
	public void delete(Long occupationId)throws ResourceNotFoundException {
		occupationService.delete(occupationId);

	}

}
