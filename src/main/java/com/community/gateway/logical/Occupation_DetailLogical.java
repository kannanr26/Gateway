package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.Occupation_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface Occupation_DetailLogical {

	List<Occupation_DetailDTO> findAll();

	Occupation_DetailDTO findById(Long occupation_detailId)throws ResourceNotFoundException;

	//Occupation_DetailDTO save(@Valid Occupation_Detail occupation_detailDTO);

	void delete(Long occupation_detailId) throws ResourceNotFoundException;

	Occupation_DetailDTO save(@Valid Occupation_DetailDTO occupation_detailDto);

}
