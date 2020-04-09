package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.Job_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.Job_DetailMapper;
import com.community.gateway.model.Job_Detail;
import com.community.gateway.service.Job_DetailService;

@Service
public class Job_DetailLogicalImpl implements Job_DetailLogical {

	@Autowired
	Job_DetailService job_detailService;
	
	@Autowired
	Job_DetailMapper job_detailMapper;

	@Override
	public List<Job_DetailDTO> findAll() {
		// TODO Auto-generated method stub
		return job_detailMapper.toJob_DetailDTOs(job_detailService.findAll());
	}

	@Override
	public Job_DetailDTO findById(Long job_detailId) throws ResourceNotFoundException {
		return job_detailMapper.toJob_DetailDTO(job_detailService.findById(job_detailId));
	}

	@Override
	public Job_DetailDTO save(@Valid Job_DetailDTO job_detailDto) {
		// TODO Auto-generated method stub
		return job_detailMapper.toJob_DetailDTO(job_detailService.save(job_detailMapper.toJob_Detail(job_detailDto)));
		
	}

	@Override
	public void delete(Long job_detailId)throws ResourceNotFoundException {
		job_detailService.delete(job_detailId);

	}

}
