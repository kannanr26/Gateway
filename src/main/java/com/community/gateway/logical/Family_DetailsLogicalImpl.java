package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.Family_DetailsDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.Family_DetailsMapper;
import com.community.gateway.service.Family_DetailsService;

@Service
public class Family_DetailsLogicalImpl implements Family_DetailsLogical {

	@Autowired
	Family_DetailsService family_detailsService;
	
	@Autowired
	Family_DetailsMapper family_detailsMapper;

	@Override
	public List<Family_DetailsDTO> findAll() {
		// TODO Auto-generated method stub
		return family_detailsMapper.toFamily_DetailsDTOs(family_detailsService.findAll());
	}

	@Override
	public Family_DetailsDTO findById(Long family_detailsId) throws ResourceNotFoundException {
		return family_detailsMapper.toFamily_DetailsDTO(family_detailsService.findById(family_detailsId));
	}

	@Override
	public Family_DetailsDTO save(@Valid Family_DetailsDTO family_detailsDto) throws Exception {
		// TODO Auto-generated method stub
		return family_detailsMapper.toFamily_DetailsDTO(family_detailsService.save(family_detailsMapper.toFamily_Details(family_detailsDto)));
		
	}

	@Override
	public void delete(Long family_detailsId)throws ResourceNotFoundException {
		family_detailsService.delete(family_detailsId);

	}

	@Override
	public Family_DetailsDTO findByRegistrationNumber(@Valid String registrationNumber)
			throws ResourceNotFoundException {
		return family_detailsMapper.toFamily_DetailsDTO(family_detailsService.findByRegistrationNumber(registrationNumber));
	}

}
