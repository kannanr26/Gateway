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
	private static final List<JobTitleDTO> jobTitles = new ArrayList<JobTitleDTO>();

	private final JobLogical jobLogical;
	private final JobTitleLogical jobTitleLogical;

	@Autowired
	public JobUtilService(JobLogical jobLogical, JobTitleLogical jobtitleLogical) {

		this.jobLogical = jobLogical;
		this.jobTitleLogical = jobtitleLogical;
	}

	public List<JobDTO> getJobs() {
		if (jobs.isEmpty()) {
			jobs.addAll(jobLogical.findAll());
		}
		return jobs;
	}

	public boolean addJobs(JobDTO jobDTO) {
		System.out.println("  jobDTO" + jobDTO.getJobName());
		if (getJobs().stream().noneMatch(x -> x.getJobName().equalsIgnoreCase(jobDTO.getJobName()))) {
			System.out.println(" inside  if jobDTO");
			JobDTO job = jobLogical.save(jobDTO);
			jobs.add(job);
			return true;
		}
		return false;
	}

	public List<JobTitleDTO> getJobTitles() {
		if (jobTitles.isEmpty()) {
			jobTitles.addAll(jobTitleLogical.findAll());
		}
		return jobTitles;
	}

	public boolean addJobTitles(JobTitleDTO jobTitleDTO) {
		if (getJobTitles().stream().noneMatch(x -> x.getJobTitleName().equalsIgnoreCase(jobTitleDTO.getJobTitleName()))) {
			JobTitleDTO jobTitleToSave;
			try {
				System.out.println(" jobTitleDTO.getJobTitleName() "+jobTitleDTO.getJobTitleName());
				jobTitleToSave = jobTitleLogical.save(jobTitleDTO);
				jobTitles.add(jobTitleToSave);

				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;

	}

	public boolean deleteJob(Long jobId) {
		// TODO Auto-generated method stub
		 try {
			
			 jobs.remove(jobLogical.findById(jobId));
			 jobLogical.delete(jobId);
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
	public boolean deleteJobTitle(Long jobTitleId) {
		// TODO Auto-generated method stub
		 try {
			 jobTitles.remove(jobTitleLogical.findById(jobTitleId));
			 jobTitleLogical.delete(jobTitleId);
			 
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}

}