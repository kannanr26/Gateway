package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface JobTitleLogical {

	List<JobTitleDTO> findAll();

	JobTitleDTO findById(Long jobtitleId)throws ResourceNotFoundException;

	//JobTitleDTO save(@Valid JobTitle jobtitleDTO);

	void delete(Long jobtitleId) throws ResourceNotFoundException;

	JobTitleDTO save(@Valid JobTitleDTO jobtitleDto) throws ResourceNotFoundException;

	JobTitleDTO findByRoleName(String roleName)  throws ResourceNotFoundException;

}
