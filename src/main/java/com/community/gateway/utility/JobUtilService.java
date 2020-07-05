package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
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

	public ResponseEntity<MessageResponse> addJobs(JobDTO jobDTO) {
		
			if (getJobs().stream().noneMatch(x -> x.getJobName().equalsIgnoreCase(jobDTO.getJobName()))) {
				JobDTO jobSaved = jobLogical.save(jobDTO);
				refreshJob();				
				if(jobDTO.getId()==0)
					return ResponseEntity.ok().body(new MessageResponse(jobSaved,true, UtilityConstant.SUCCESS));
				else
					return ResponseEntity.ok().body(new MessageResponse(true,UtilityConstant.UPDATED_SUCCESS));
			}
			return ResponseEntity.badRequest().body(new MessageResponse(true, UtilityConstant.FAILED));
	}

	private void refreshJob() {
		// TODO Auto-generated method stub
		jobs.clear();
		getJobs();
	}

	public List<JobTitleDTO> getJobTitles() {
		if (jobTitles.isEmpty()) {
			jobTitles.addAll(jobTitleLogical.findAll());
		}
		return jobTitles;
	}

	public ResponseEntity<MessageResponse> addJobTitles(JobTitleDTO jobTitleDTO) {
		try {
			
			if (getJobTitles().stream()
					.noneMatch(x -> x.getJobTitleName().equalsIgnoreCase(jobTitleDTO.getJobTitleName()))) {
				JobTitleDTO jobTitleToSave = jobTitleLogical.save(jobTitleDTO);
				
				refreshJobTilte();
				if(jobTitleDTO.getId()==0)
					return ResponseEntity.ok().body(new MessageResponse(jobTitleToSave,true, UtilityConstant.SUCCESS));
				else
					return ResponseEntity.ok().body(new MessageResponse(true,UtilityConstant.UPDATED_SUCCESS));
			}
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
	return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));

	}

	private void refreshJobTilte() {
		// TODO Auto-generated method stub
		jobTitles.clear();
		getJobTitles();
	}

	public boolean deleteJob(Long jobId) {
		// TODO Auto-generated method stub
		try {
			jobLogical.delete(jobId);
			refreshJob();
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
			jobTitleLogical.delete(jobTitleId);
			refreshJobTilte();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}