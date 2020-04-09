package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.Job_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface Job_DetailLogical {

	List<Job_DetailDTO> findAll();

	Job_DetailDTO findById(Long job_detailId)throws ResourceNotFoundException;

	//Job_DetailDTO save(@Valid Job_Detail job_detailDTO);

	void delete(Long job_detailId) throws ResourceNotFoundException;

	Job_DetailDTO save(@Valid Job_DetailDTO job_detailDto);

}
