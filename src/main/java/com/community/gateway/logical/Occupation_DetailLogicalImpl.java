package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.Occupation_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.Occupation_DetailMapper;
import com.community.gateway.model.Occupation_Detail;
import com.community.gateway.service.Occupation_DetailService;

@Service
public class Occupation_DetailLogicalImpl implements Occupation_DetailLogical {

	@Autowired
	Occupation_DetailService occupation_detailService;
	
	@Autowired
	Occupation_DetailMapper occupation_detailMapper;

	@Override
	public List<Occupation_DetailDTO> findAll() {
		// TODO Auto-generated method stub
		return occupation_detailMapper.toOccupation_DetailDTOs(occupation_detailService.findAll());
	}

	@Override
	public Occupation_DetailDTO findById(Long occupation_detailId) throws ResourceNotFoundException {
		return occupation_detailMapper.toOccupation_DetailDTO(occupation_detailService.findById(occupation_detailId));
	}

	@Override
	public Occupation_DetailDTO save(@Valid Occupation_DetailDTO occupation_detailDto) {
		// TODO Auto-generated method stub
		return occupation_detailMapper.toOccupation_DetailDTO(occupation_detailService.save(occupation_detailMapper.toOccupation_Detail(occupation_detailDto)));
		
	}

	@Override
	public void delete(Long occupation_detailId)throws ResourceNotFoundException {
		occupation_detailService.delete(occupation_detailId);

	}

}
