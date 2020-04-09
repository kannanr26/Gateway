package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.CasteDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface CasteLogical {

	List<CasteDTO> findAll();

	CasteDTO findById(Long casteId)throws ResourceNotFoundException;

	//CasteDTO save(@Valid Caste casteDTO);

	void delete(Long casteId) throws ResourceNotFoundException;

	CasteDTO save(@Valid CasteDTO casteDto);

}
