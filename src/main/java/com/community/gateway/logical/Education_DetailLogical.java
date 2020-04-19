package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.Education_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface Education_DetailLogical {

	List<Education_DetailDTO> findAll();

	Education_DetailDTO findById(Long education_detailId)throws ResourceNotFoundException;
	
	void delete(Long education_detailId) throws ResourceNotFoundException;

	Education_DetailDTO save(@Valid Education_DetailDTO education_detailDto);

}
