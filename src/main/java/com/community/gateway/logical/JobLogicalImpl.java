package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.JobDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.JobMapper;
import com.community.gateway.model.Job;
import com.community.gateway.service.JobService;

@Service
public class JobLogicalImpl implements JobLogical {

	@Autowired
	JobService jobService;
	
	@Autowired
	JobMapper jobMapper;

	@Override
	public List<JobDTO> findAll() {
		// TODO Auto-generated method stub
		return jobMapper.toJobDTOs(jobService.findAll());
	}

	@Override
	public JobDTO findById(Long jobId) throws ResourceNotFoundException {
		return jobMapper.toJobDTO(jobService.findById(jobId));
	}

	@Override
	public JobDTO save(@Valid JobDTO jobDto) {
		// TODO Auto-generated method stub
		return jobMapper.toJobDTO(jobService.save(jobMapper.toJob(jobDto)));
		
	}

	@Override
	public void delete(Long jobId)throws ResourceNotFoundException {
		jobService.delete(jobId);

	}

}
