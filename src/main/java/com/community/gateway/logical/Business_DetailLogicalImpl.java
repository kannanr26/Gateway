package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.Business_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.Business_DetailMapper;
import com.community.gateway.model.Business_Detail;
import com.community.gateway.service.Business_DetailService;

@Service
public class Business_DetailLogicalImpl implements Business_DetailLogical {

	@Autowired
	Business_DetailService business_detailService;
	
	@Autowired
	Business_DetailMapper business_detailMapper;

	@Override
	public List<Business_DetailDTO> findAll() {
		// TODO Auto-generated method stub
		return business_detailMapper.toBusiness_DetailDTOs(business_detailService.findAll());
	}

	@Override
	public Business_DetailDTO findById(Long business_detailId) throws ResourceNotFoundException {
		return business_detailMapper.toBusiness_DetailDTO(business_detailService.findById(business_detailId));
	}

	@Override
	public Business_DetailDTO save(@Valid Business_DetailDTO business_detailDto) {
		// TODO Auto-generated method stub
		return business_detailMapper.toBusiness_DetailDTO(business_detailService.save(business_detailMapper.toBusiness_Detail(business_detailDto)));
		
	}

	@Override
	public void delete(Long business_detailId)throws ResourceNotFoundException {
		business_detailService.delete(business_detailId);

	}

}
