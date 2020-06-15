package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.StateDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.StateMapper;
import com.community.gateway.service.StateService;

@Service
public class StateLogicalImpl implements StateLogical {

	@Autowired
	StateService stateService;
	
	@Autowired
	StateMapper stateMapper;

	@Override
	public List<StateDTO> findAll() {
		// TODO Auto-generated method stub
		return stateMapper.toStateDTOs(stateService.findAll());
	}

	@Override
	public StateDTO findById(Long stateId) throws ResourceNotFoundException {
		return stateMapper.toStateDTO(stateService.findById(stateId));
	}

	@Override
	public StateDTO save(@Valid StateDTO stateDto) {
		// TODO Auto-generated method stub
		System.out.println(" stateDto :"+stateDto.getStateName());
		return stateMapper.toStateDTO(stateService.save(stateMapper.toState(stateDto)));
		
	}

	@Override
	public void delete(Long stateId)throws ResourceNotFoundException {
		stateService.delete(stateId);

	}

	@Override
	public List<StateDTO> findAllByCountryId(Long countryId) {
		// TODO Auto-generated method stub
		return stateMapper.toStateDTOs(stateService.findAllByCountryId(countryId));
	}

}