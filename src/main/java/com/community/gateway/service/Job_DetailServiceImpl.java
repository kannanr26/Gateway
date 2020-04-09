package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Job_Detail;
import com.community.gateway.model.repo.Job_DetailRepository;

@Service
public class Job_DetailServiceImpl implements Job_DetailService {

	@Autowired
	Job_DetailRepository job_detailRepository;

	@Override
	public Job_Detail findById(Long job_detailId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Job_Detail job_detail = job_detailRepository.findById(job_detailId).orElseThrow(
				() -> new ResourceNotFoundException("Operator not found for this id :: " + job_detailId));
		return job_detail;
	}

	@Override
	public List<Job_Detail> findAll() {
		List<Job_Detail> list = new ArrayList<>();
		Iterable<Job_Detail> customers = job_detailRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long job_detailId) {
		job_detailRepository.deleteById(job_detailId);

	}

	@Override
	public Job_Detail save(@Valid Job_Detail job_detail) {
		// TODO Auto-generated method stub
		return job_detailRepository.save(job_detail);
	}
}
