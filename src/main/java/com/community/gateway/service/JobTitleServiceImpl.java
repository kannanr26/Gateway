package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.JobTitle;
import com.community.gateway.model.repo.JobTitleRepository;

@Service
public class JobTitleServiceImpl implements JobTitleService {

	@Autowired
	JobTitleRepository jobtitleRepository;

	@Override
	public JobTitle findById(Long jobtitleId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		JobTitle jobtitle = jobtitleRepository.findById(jobtitleId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + jobtitleId));
		return jobtitle;
	}

	@Override
	public List<JobTitle> findAll() {
		List<JobTitle> list = new ArrayList<>();
		Iterable<JobTitle> customers = jobtitleRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long jobtitleId) {
		jobtitleRepository.deleteById(jobtitleId);

	}

	@Override
	public JobTitle save(@Valid JobTitle jobtitle) {
		// TODO Auto-generated method stub
		return jobtitleRepository.save(jobtitle);
	}

	@Override
	public JobTitle findByRoleName(String roleName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		JobTitle jobtitle = jobtitleRepository.findByRoleName(roleName)
				.orElseThrow(() -> new ResourceNotFoundException("JobTitle not found for this id :: " + roleName));
		return jobtitle;
	}
}
