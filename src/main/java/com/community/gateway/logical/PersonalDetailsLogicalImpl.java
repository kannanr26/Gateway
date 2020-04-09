package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.PersonalDetailsDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.PersonalDetailsMapper;
import com.community.gateway.model.PersonalDetails;
import com.community.gateway.service.PersonalDetailsService;

@Service
public class PersonalDetailsLogicalImpl implements PersonalDetailsLogical {

	@Autowired
	PersonalDetailsService personaldetailsService;
	
	@Autowired
	PersonalDetailsMapper personaldetailsMapper;

	@Override
	public List<PersonalDetailsDTO> findAll() {
		// TODO Auto-generated method stub
		return personaldetailsMapper.toPersonalDetailsDTOs(personaldetailsService.findAll());
	}

	@Override
	public PersonalDetailsDTO findById(Long personaldetailsId) throws ResourceNotFoundException {
		return personaldetailsMapper.toPersonalDetailsDTO(personaldetailsService.findById(personaldetailsId));
	}

	@Override
	public PersonalDetailsDTO save(@Valid PersonalDetailsDTO personaldetailsDto) {
		// TODO Auto-generated method stub
		return personaldetailsMapper.toPersonalDetailsDTO(personaldetailsService.save(personaldetailsMapper.toPersonalDetails(personaldetailsDto)));
		
	}

	@Override
	public void delete(Long personaldetailsId)throws ResourceNotFoundException {
		personaldetailsService.delete(personaldetailsId);

	}

}
