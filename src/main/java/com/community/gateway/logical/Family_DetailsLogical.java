package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.Family_DetailsDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;

public interface Family_DetailsLogical {

	List<Family_DetailsDTO> findAll();

	Family_DetailsDTO findById(Long family_detailsId)throws ResourceNotFoundException;

	//Family_DetailsDTO save(@Valid Family_Details family_detailsDTO);

	void delete(Long family_detailsId) throws ResourceNotFoundException;

	Family_DetailsDTO save(@Valid Family_DetailsDTO family_detailsDto) throws Exception;

}
