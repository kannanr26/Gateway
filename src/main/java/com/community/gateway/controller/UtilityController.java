package com.community.gateway.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.EducationDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.dto.RoleDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.model.Business;
import com.community.gateway.model.JobTitle;
import com.community.gateway.model.e_num.EOperator;
import com.community.gateway.service.BusinessService;
import com.community.gateway.service.RoleService;
import com.community.gateway.utility.AddressUtilService;
import com.community.gateway.utility.BusinessUtilService;
import com.community.gateway.utility.CoursesUtilService;
import com.community.gateway.utility.EducationUtilService;
import com.community.gateway.utility.EnumUtilService;
import com.community.gateway.utility.FamilyUtilService;
import com.community.gateway.utility.JobUtilService;
import com.community.gateway.utility.RoleUtilService;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;

@RestController
@RequestMapping("/gws")
public class UtilityController {

	private final FamilyUtilService familyService;
	private final AddressUtilService addressService;
	private final BusinessUtilService businessService;
	private final CoursesUtilService courseService;
	private final EducationUtilService educationService;
	private final JobUtilService jobService;
	private final RoleUtilService roleService;
	private final EnumUtilService enumService;

	@Autowired
	public UtilityController(FamilyUtilService familyService, AddressUtilService addressService,BusinessUtilService businessService,
			CoursesUtilService coursesService,EducationUtilService educationService,JobUtilService jobService,
			RoleUtilService roleService,EnumUtilService enumService) {
		this.familyService = familyService;
		this.addressService = addressService;
		this.businessService=businessService;
		this.courseService=coursesService;
		this.educationService=educationService;
		this.jobService=jobService;
		this.roleService=roleService;
		this.enumService=enumService;
				

	}

	@PostMapping("/addkulam")
	public ResponseEntity<MessageResponse> addKulam(@Valid @RequestBody KulamDTO kulam) {
		System.out.println(" Before if ");
		if (familyService.addKulams(kulam)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Kulam added Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Kulam not Successfully "));

	}

	@GetMapping("/getkulams")
	public ResponseEntity<List<KulamDTO>> getKulams() {
		return ResponseEntity.ok().body(familyService.getKulams());
	}

	@PostMapping("/addgothiram")
	public ResponseEntity<MessageResponse> addGothiram(@Valid @RequestBody GothiramDTO gothirams) {
		if (familyService.addGothirams(gothirams))
			return ResponseEntity.ok().body(new MessageResponse(true, "Gothiram added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Gothiram not Successfully "));

	}

	@GetMapping("/getgothirams")
	public ResponseEntity<List<GothiramDTO>> getGothirams() {
		return ResponseEntity.ok().body(familyService.getGothirams());
	}

	@PostMapping("/adddeity")
	public ResponseEntity<MessageResponse> addDeity(@Valid @RequestBody DeityDTO deity) {
		if (familyService.addDeitys(deity))
			return ResponseEntity.ok().body(new MessageResponse(true, "Deity added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deity not Successfully "));
	}

	@GetMapping("/getdeitys")
	public ResponseEntity<List<DeityDTO>> getDeitys() {
		return ResponseEntity.ok().body(familyService.getDeitys());
	}

	@PostMapping("/addcity")
	public ResponseEntity<MessageResponse> addCity(@Valid @RequestBody CityDTO city) {
		if (addressService.addCities(city))
			return ResponseEntity.ok().body(new MessageResponse(true, "City added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "City not Successfully "));

	}

	@GetMapping("/getcity")
	public ResponseEntity<List<CityDTO>> getCity() {
		return ResponseEntity.ok().body(addressService.getCities());
	}

	@PostMapping("/addjob")
	public ResponseEntity<MessageResponse> addJob(@Valid @RequestBody JobDTO job) {
		if (jobService.addJobs(job))
			return ResponseEntity.ok().body(new MessageResponse(true, "Job added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Job not Successfully "));

	}

	@GetMapping("/getjob")
	public ResponseEntity<List<JobDTO>> getJob() {
		return ResponseEntity.ok().body(jobService.getJobs());
	}

	
	@PostMapping("/addjobtitle")
	public ResponseEntity<MessageResponse> addJobTitle(@Valid @RequestBody JobTitleDTO jobTitle) {
		if (jobService.addJobTitles(jobTitle))
			return ResponseEntity.ok().body(new MessageResponse(true, "Job Title added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Job Title not Successfully "));

	}

	@GetMapping("/getjobtitle")
	public ResponseEntity<List<JobTitleDTO>> getJobTitle() {
		return ResponseEntity.ok().body(jobService.getJobTitles());
	}


	@PostMapping("/addeducation")
	public ResponseEntity<MessageResponse> addEducation(@Valid @RequestBody EducationDTO education) {
		if (educationService.addEducations(education))
			return ResponseEntity.ok().body(new MessageResponse(true, "Education added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Education not Successfully "));

	}

	@GetMapping("/geteducation")
	public ResponseEntity<List<EducationDTO>> getEducation() {
		return ResponseEntity.ok().body(educationService.getEducations());
	}
	

	@PostMapping("/addcourses")
	public ResponseEntity<MessageResponse> addCourse(@Valid @RequestBody CoursesDTO courses) {
		if (courseService.addCourses(courses))
			return ResponseEntity.ok().body(new MessageResponse(true, "Course added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Course not Successfully "));

	}

	@GetMapping("/getcourses")
	public ResponseEntity<List<CoursesDTO>> getCourses() {
		return ResponseEntity.ok().body(courseService.getCourses());
	}
	

	@PostMapping("/addbusiness")
	public ResponseEntity<MessageResponse> addBusiness(@Valid @RequestBody BusinessDTO business) {
		if (businessService.addbusiness(business))
			return ResponseEntity.ok().body(new MessageResponse(true, "Business added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " Business not Successfully "));

	}

	@GetMapping("/getbusiness")
	public ResponseEntity<List<BusinessDTO>> getBusiness() {
		return ResponseEntity.ok().body(businessService.getBusiness());
	}
	

	@PostMapping("/addRole")
	public ResponseEntity<MessageResponse> addRoles(@Valid @RequestBody RoleDTO roleDto) {
		if (roleService.addRoles(roleDto))
			return ResponseEntity.ok().body(new MessageResponse(true, "Role added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Role not Successfully "));

	}

	@GetMapping("/getrole")
	public ResponseEntity<List<RoleDTO>> getRoles() {
		return ResponseEntity.ok().body(roleService.getRoles());
	}
	
	

	/*
	 * @PostMapping("/util/addoperatortype") public ResponseEntity<MessageResponse>
	 * addOperatorType(@Valid @RequestBody JobTitleDTO jobTitle) { if
	 * (jobService.addJobTitles(jobTitle)) return ResponseEntity.ok().body(new
	 * MessageResponse(true, "Job Title added Successfully ")); else return
	 * ResponseEntity.badRequest().body(new MessageResponse(false,
	 * "Job Title not Successfully "));
	 * 
	 * }
	 */

	@GetMapping("/getoperatortype")
	public ResponseEntity<List<EOperator>> getOpeatorType() {
		return ResponseEntity.ok().body(enumService.getOperatorType());
	}
}
