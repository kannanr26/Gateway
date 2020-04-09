package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CasteDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.CasteMapper;
import com.community.gateway.service.CasteService;

@Service
public class CasteLogicalImpl implements CasteLogical {

	@Autowired
	CasteService casteService;
	
	@Autowired
	CasteMapper casteMapper;

	@Override
	public List<CasteDTO> findAll() {
		// TODO Auto-generated method stub
		return casteMapper.toCasteDTOs(casteService.findAll());
	}

	@Override
	public CasteDTO findById(Long casteId) throws ResourceNotFoundException {
		return casteMapper.toCasteDTO(casteService.findById(casteId));
	}

	@Override
	public CasteDTO save(@Valid CasteDTO casteDto) {
		// TODO Auto-generated method stub
		return casteMapper.toCasteDTO(casteService.save(casteMapper.toCaste(casteDto)));
		
	}

	@Override
	public void delete(Long casteId)throws ResourceNotFoundException {
		casteService.delete(casteId);

	}

}
