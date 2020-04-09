package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface GothiramLogical {

	List<GothiramDTO> findAll();

	GothiramDTO findById(Long gothiramId)throws ResourceNotFoundException;

	//GothiramDTO save(@Valid Gothiram gothiramDTO);

	void delete(Long gothiramId) throws ResourceNotFoundException;

	GothiramDTO save(@Valid GothiramDTO gothiramDto);

}
