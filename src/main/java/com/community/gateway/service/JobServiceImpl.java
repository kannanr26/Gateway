package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Job;
import com.community.gateway.model.repo.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;

	@Override
	public Job findById(Long jobId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Job job = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + jobId));
		return job;
	}

	@Override
	public List<Job> findAll() {
		List<Job> list = new ArrayList<>();
		Iterable<Job> customers = jobRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long jobId) {
		jobRepository.deleteById(jobId);

	}

	@Override
	public Job save(@Valid Job job) {
		// TODO Auto-generated method stub
		return jobRepository.save(job);
	}
}
