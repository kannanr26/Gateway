package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.DeityDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.DeityMapper;
import com.community.gateway.model.Deity;
import com.community.gateway.service.DeityService;

@Service
public class DeityLogicalImpl implements DeityLogical {

	@Autowired
	DeityService deityService;
	
	@Autowired
	DeityMapper deityMapper;

	@Override
	public List<DeityDTO> findAll() {
		// TODO Auto-generated method stub
		return deityMapper.toDeityDTOs(deityService.findAll());
	}

	@Override
	public DeityDTO findById(Long deityId) throws ResourceNotFoundException {
		return deityMapper.toDeityDTO(deityService.findById(deityId));
	}

	@Override
	public DeityDTO save(@Valid DeityDTO deityDto) {
		// TODO Auto-generated method stub
		return deityMapper.toDeityDTO(deityService.save(deityMapper.toDeity(deityDto)));
		
	}

	@Override
	public void delete(Long deityId)throws ResourceNotFoundException {
		deityService.delete(deityId);

	}

	@Override
	public List<DeityDTO> findByCityId(Long cityId) {
		// TODO Auto-generated method stub
		return deityMapper.toDeityDTOs(deityService.findByCityId(cityId));
	}

}
