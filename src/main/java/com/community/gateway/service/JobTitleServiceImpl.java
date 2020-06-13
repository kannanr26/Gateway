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
	JobTitleRepository jobTitleRepository;

	@Override
	public JobTitle findById(Long jobtitleId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		JobTitle jobtitle = jobTitleRepository.findById(jobtitleId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + jobtitleId));
		return jobtitle;
	}

	@Override
	public List<JobTitle> findAll() {
		List<JobTitle> list = new ArrayList<>();
		Iterable<JobTitle> customers = jobTitleRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long jobtitleId) {
		jobTitleRepository.deleteById(jobtitleId);

	}

	@Override
	public JobTitle save(@Valid JobTitle jobTitle) {
		// TODO Auto-generated method stub
		System.out.println(" Job Title "+jobTitle);
		return jobTitleRepository.save(jobTitle);
	}

	@Override
	public JobTitle findByJobTitleName(String jobTitleName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		JobTitle jobtitle = jobTitleRepository.findByJobTitleName(jobTitleName)
				.orElseThrow(() -> new ResourceNotFoundException("JobTitle not found for this id :: " + jobTitleName));
		return jobtitle;
	}
}
