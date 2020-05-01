package com.community.gateway.logical;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.GothiramMapper;
import com.community.gateway.model.Gothiram;
import com.community.gateway.service.GothiramService;

@Service
public class GothiramLogicalImpl implements GothiramLogical {

	@Autowired
	GothiramService gothiramService;

	@Autowired
	GothiramMapper gothiramMapper;

	@Override
	public List<GothiramDTO> findAll() {
		// TODO Auto-generated method stub
		return gothiramMapper.toGothiramDTOs(gothiramService.findAll());

	}

	@Override
	public GothiramDTO findById(Long gothiramId) throws ResourceNotFoundException {
		return gothiramMapper.toGothiramDTO(gothiramService.findById(gothiramId));
	}

	@Override
	public GothiramDTO save(@Valid GothiramDTO gothiramDto) {
		// TODO Auto-generated method stub
		return gothiramMapper.toGothiramDTO(gothiramService.save(gothiramMapper.toGothiram(gothiramDto)));

	}

	@Override
	public void delete(Long gothiramId) throws ResourceNotFoundException {
		gothiramService.delete(gothiramId);

	}

}
