package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.JobLogical;
import com.community.gateway.logical.JobTitleLogical;

@Service
public class JobUtilService {

	private static final List<JobDTO> jobs = new ArrayList<JobDTO>();
	private static final List<JobTitleDTO> jobtitles = new ArrayList<JobTitleDTO>();

	private final JobLogical jobLogical;
	private final JobTitleLogical jobtitleLogical;

	@Autowired
	public JobUtilService(JobLogical jobLogical, JobTitleLogical jobtitleLogical) {

		this.jobLogical = jobLogical;
		this.jobtitleLogical = jobtitleLogical;
	}

	public List<JobDTO> getJobs() {
		if (jobs.isEmpty()) {
			jobs.addAll(jobLogical.findAll());
		}
		return jobs;
	}

	public boolean addJobs(JobDTO jobDTO) {
		System.out.println("  jobDTO" + jobDTO.getRoleName());
		if (getJobs().stream().noneMatch(x -> x.getRoleName().equalsIgnoreCase(jobDTO.getRoleName()))) {
			System.out.println(" inside  if jobDTO");
			JobDTO job = jobLogical.save(jobDTO);
			jobs.add(job);
			return true;
		}
		return false;
	}

	public List<JobTitleDTO> getJobTitles() {
		if (jobtitles.isEmpty()) {
			jobtitles.addAll(jobtitleLogical.findAll());
		}
		return jobtitles;
	}

	public boolean addJobTitles(JobTitleDTO jobtitleDTO) {
		if (getJobTitles().stream().noneMatch(x -> x.getRoleName().equalsIgnoreCase(jobtitleDTO.getRoleName()))) {
			JobTitleDTO jobtitle;
			try {
				jobtitle = jobtitleLogical.save(jobtitleDTO);
				jobtitles.add(jobtitle);

				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;

	}

}