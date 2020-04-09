package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.Education_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.Education_DetailMapper;
import com.community.gateway.model.Education_Detail;
import com.community.gateway.service.Education_DetailService;

@Service
public class Education_DetailLogicalImpl implements Education_DetailLogical {

	@Autowired
	Education_DetailService education_detailService;
	
	@Autowired
	Education_DetailMapper education_detailMapper;

	@Override
	public List<Education_DetailDTO> findAll() {
		// TODO Auto-generated method stub
		return education_detailMapper.toEducation_DetailDTOs(education_detailService.findAll());
	}

	@Override
	public Education_DetailDTO findById(Long education_detailId) throws ResourceNotFoundException {
		return education_detailMapper.toEducation_DetailDTO(education_detailService.findById(education_detailId));
	}

	@Override
	public Education_DetailDTO save(@Valid Education_DetailDTO education_detailDto) {
		// TODO Auto-generated method stub
		return education_detailMapper.toEducation_DetailDTO(education_detailService.save(education_detailMapper.toEducation_Detail(education_detailDto)));
		
	}

	@Override
	public void delete(Long education_detailId)throws ResourceNotFoundException {
		education_detailService.delete(education_detailId);

	}

}
