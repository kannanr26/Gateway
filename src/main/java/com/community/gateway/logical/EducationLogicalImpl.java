package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.EducationDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.EducationMapper;
import com.community.gateway.model.Education;
import com.community.gateway.service.EducationService;

@Service
public class EducationLogicalImpl implements EducationLogical {

	@Autowired
	EducationService educationService;
	
	@Autowired
	EducationMapper educationMapper;

	@Override
	public List<EducationDTO> findAll() {
		// TODO Auto-generated method stub
		return educationMapper.toEducationDTOs(educationService.findAll());
	}

	@Override
	public EducationDTO findById(Long educationId) throws ResourceNotFoundException {
		return educationMapper.toEducationDTO(educationService.findById(educationId));
	}

	@Override
	public EducationDTO save(@Valid EducationDTO educationDto) {
		// TODO Auto-generated method stub
		return educationMapper.toEducationDTO(educationService.save(educationMapper.toEducation(educationDto)));
		
	}

	@Override
	public void delete(Long educationId)throws ResourceNotFoundException {
		educationService.delete(educationId);

	}

	@Override
	public EducationDTO findByEducationName(String education) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return educationMapper.toEducationDTO(educationService.findByEducationName(education));
	}

}
