package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.BusinessMapper;
import com.community.gateway.model.Business;
import com.community.gateway.service.BusinessService;

@Service
public class BusinessLogicalImpl implements BusinessLogical {

	@Autowired
	BusinessService businessService;
	
	@Autowired
	BusinessMapper businessMapper;

	@Override
	public List<BusinessDTO> findAll() {
		// TODO Auto-generated method stub
		return businessMapper.toBusinessDTOs(businessService.findAll());
	}

	@Override
	public BusinessDTO findById(Long businessId) throws ResourceNotFoundException {
		return businessMapper.toBusinessDTO(businessService.findById(businessId));
	}

	@Override
	public BusinessDTO save(@Valid BusinessDTO businessDto) {
		// TODO Auto-generated method stub
		return businessMapper.toBusinessDTO(businessService.save(businessMapper.toBusiness(businessDto)));
		
	}

	@Override
	public void delete(Long businessId)throws ResourceNotFoundException {
		businessService.delete(businessId);

	}

}
