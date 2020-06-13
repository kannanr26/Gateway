package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.JobDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface JobLogical {

	List<JobDTO> findAll();

	JobDTO findById(Long jobId)throws ResourceNotFoundException;
	
	JobDTO findByJobName(String jobName)throws ResourceNotFoundException;
	
	void delete(Long jobId) throws ResourceNotFoundException;

	JobDTO save(@Valid JobDTO jobDto);

}
