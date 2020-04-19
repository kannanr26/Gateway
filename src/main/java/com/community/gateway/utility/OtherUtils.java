package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.EducationDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.BusinessLogical;
import com.community.gateway.logical.CoursesLogical;
import com.community.gateway.logical.DeityLogical;
import com.community.gateway.logical.EducationLogical;
import com.community.gateway.logical.GothiramLogical;
import com.community.gateway.logical.JobLogical;
import com.community.gateway.logical.JobTitleLogical;
import com.community.gateway.logical.KulamLogical;

public class OtherUtils {


	@Autowired
	private static JobLogical jobLogical;

	@Autowired
	private static JobTitleLogical jobTitleLogical;

	@Autowired
	private static EducationLogical educationLogical;

	@Autowired
	private static CoursesLogical coursesLogical;
	
	@Autowired
	private static BusinessLogical businessLogical;
	
	private static List<JobDTO> jobList;
	private static List<CoursesDTO> coursesList;
	private static List<JobTitleDTO> jobTitleList;
	private static List<EducationDTO> educationList;
	private static List<BusinessDTO> businessList;
	
	public static List<JobDTO> getJobList() {
		if (OtherUtils.jobList == null)  {
			OtherUtils.jobList= new ArrayList<JobDTO>();
			OtherUtils.jobList= jobLogical.findAll();
		}
		return OtherUtils.jobList;
	}
	public static List<CoursesDTO> getCoursesList() {
		return coursesList;
	}
	public static List<JobTitleDTO> getJobTitleList() {
		if (OtherUtils.jobTitleList == null)  {
			OtherUtils.jobTitleList= new ArrayList<JobTitleDTO>();
			OtherUtils.jobTitleList= jobTitleLogical.findAll();
		}
		return OtherUtils.jobTitleList;
	}
	public static List<EducationDTO> getEducationList() {
		if (OtherUtils.educationList == null)  {
			OtherUtils.educationList= new ArrayList<EducationDTO>();
			OtherUtils.educationList= educationLogical.findAll();
		}
		return OtherUtils.educationList;
	}
	public static List<BusinessDTO> getBusinessList() {
		if (OtherUtils.businessList == null)  {
			OtherUtils.businessList= new ArrayList<BusinessDTO>();
			OtherUtils.businessList= businessLogical.findAll();
		}
		return OtherUtils.businessList;
	}
	public static void setJobLocial(JobLogical jobLogical) {
		OtherUtils.jobLogical = jobLogical;
	}
	public static void setJobTitleLocial(JobTitleLogical jobTitleLogical) {
		OtherUtils.jobTitleLogical = jobTitleLogical;
	}
	public static void setEducationLocial(EducationLogical educationLogical) {
		OtherUtils.educationLogical = educationLogical;
	}
	public static void setCoursesLocial(CoursesLogical coursesLogical) {
		OtherUtils.coursesLogical = coursesLogical;
	}
	public static void setBusinessLocial(BusinessLogical businessLogical) {
		OtherUtils.businessLogical = businessLogical;
	}
	public static MessageResponse addJob(JobDTO job) {
		if (!getJobList().contains(job)) {
			JobDTO jobtoSaved;
			//try {
				jobtoSaved = jobLogical.save(job);
				OtherUtils.jobList.add(jobtoSaved);
				return new MessageResponse(true,"Job added Successfully");
			/*
			 * } catch (ResourceNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		}
		return new MessageResponse(true,"JobTitle added Successfully");
	}
	public static MessageResponse addCourses(CoursesDTO course) {
		if (!getCoursesList().contains(course)) {
			CoursesDTO coursetoSaved;
			try {
				coursetoSaved = coursesLogical.save(course);
				OtherUtils.coursesList.add(coursetoSaved);
				
				return new MessageResponse(true,"Course added Successfully");
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new MessageResponse(false,"Course not added");
	}
	public static MessageResponse addJobTitle(JobTitleDTO jobTitle) {
		if (!getJobTitleList().contains(jobTitle)) {
			JobTitleDTO jobTitletoSaved;
			try {
				jobTitletoSaved = jobTitleLogical.save(jobTitle);
				OtherUtils.jobTitleList.add(jobTitletoSaved);
				return new MessageResponse(true,"JobTitle added Successfully");
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new MessageResponse(false,"JobTitle not added");
	}
	public static MessageResponse addEducation(EducationDTO education) {
		if (!getEducationList().contains(education)) {
			EducationDTO educationtoSaved = educationLogical.save(education);
			OtherUtils.educationList.add(educationtoSaved);
			return new MessageResponse(true,"Education added Successfully");
		}
		return new MessageResponse(false,"Education not added");
	}
	public static MessageResponse addBusiness(BusinessDTO business) {
		
		if (!getBusinessList().contains(business)) {
			BusinessDTO businessdtoSaved = businessLogical.save(business);
			OtherUtils.businessList.add(businessdtoSaved);
			return new MessageResponse(true,"Business added Successfully");
		}
		return new MessageResponse(false,"Business not added");

	}
	
	
}
