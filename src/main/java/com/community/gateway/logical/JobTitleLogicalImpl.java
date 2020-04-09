package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.JobTitleMapper;
import com.community.gateway.model.JobTitle;
import com.community.gateway.service.JobTitleService;

@Service
public class JobTitleLogicalImpl implements JobTitleLogical {

	@Autowired
	JobTitleService jobtitleService;
	
	@Autowired
	JobTitleMapper jobtitleMapper;

	@Override
	public List<JobTitleDTO> findAll() {
		// TODO Auto-generated method stub
		return jobtitleMapper.toJobTitleDTOs(jobtitleService.findAll());
	}

	@Override
	public JobTitleDTO findById(Long jobtitleId) throws ResourceNotFoundException {
		return jobtitleMapper.toJobTitleDTO(jobtitleService.findById(jobtitleId));
	}

	@Override
	public JobTitleDTO save(@Valid JobTitleDTO jobtitleDto) {
		// TODO Auto-generated method stub
		return jobtitleMapper.toJobTitleDTO(jobtitleService.save(jobtitleMapper.toJobTitle(jobtitleDto)));
		
	}

	@Override
	public void delete(Long jobtitleId)throws ResourceNotFoundException {
		jobtitleService.delete(jobtitleId);

	}

}
