package com.community.gateway.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.BloodGroupDTO;
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
import com.community.gateway.model.e_num.EOperator;
import com.community.gateway.utility.AddressUtilService;
import com.community.gateway.utility.BusinessUtilService;
import com.community.gateway.utility.CoursesUtilService;
import com.community.gateway.utility.EducationUtilService;
import com.community.gateway.utility.EnumUtilService;
import com.community.gateway.utility.FamilyUtilService;
import com.community.gateway.utility.JobUtilService;
import com.community.gateway.utility.PersonalUtilService;
import com.community.gateway.utility.RoleUtilService;

@CrossOrigin(origins = "http://localhost:8080")

@RestController
@RequestMapping("/gws")
public class UtilityController {

	private final FamilyUtilService familyService;
	private final PersonalUtilService personService;
	private final AddressUtilService addressService;
	private final BusinessUtilService businessService;
	private final CoursesUtilService courseService;
	private final EducationUtilService educationService;
	private final JobUtilService jobService;
	private final RoleUtilService roleService;
	private final EnumUtilService enumService;

	@Autowired
	public UtilityController(FamilyUtilService familyService, AddressUtilService addressService,
			BusinessUtilService businessService, CoursesUtilService coursesService,
			EducationUtilService educationService, JobUtilService jobService, RoleUtilService roleService,
			EnumUtilService enumService,PersonalUtilService personService) {
		this.familyService = familyService;
		this.addressService = addressService;
		this.businessService = businessService;
		this.courseService = coursesService;
		this.educationService = educationService;
		this.jobService = jobService;
		this.roleService = roleService;
		this.personService=personService;
		this.enumService = enumService;
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

	@PutMapping("/putkulam/{id}")

	public ResponseEntity<MessageResponse> editKulam(@PathVariable(value = "id") Long kulamId,
			@RequestBody KulamDTO kulam) {
		System.out.println(" Before if ");
		if (familyService.addKulams(kulam)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Kulam added Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Kulam not Successfully "));

	}

	@DeleteMapping("/deleteKulam/{id}")
	public ResponseEntity<MessageResponse> deleteKulam(@PathVariable(value = "id") Long kulamId)
			throws ResourceNotFoundException {
		if (familyService.deleteKulams(kulamId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Not deleted Successfully "));
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

	@DeleteMapping("/deletegothiram/{id}")
	public ResponseEntity<MessageResponse> deleteGothiram(@PathVariable(value = "id") Long gothiramId)
			throws ResourceNotFoundException {
		if (familyService.deleteGothiram(gothiramId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
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

	@DeleteMapping("/deletedeity/{id}")
	public ResponseEntity<MessageResponse> deleteDeity(@PathVariable(value = "id") Long deityId)
			throws ResourceNotFoundException {
		if (familyService.deleteDeity(deityId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addcity")
	public ResponseEntity<MessageResponse> addCity(@Valid @RequestBody CityDTO city) {
		if (addressService.addCities(city))
			return ResponseEntity.ok().body(new MessageResponse(true, "City added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "City not Successfully "));

	}

	@GetMapping("/getcitys")
	public ResponseEntity<List<CityDTO>> getCity() {
		return ResponseEntity.ok().body(addressService.getCities());
	}

	@DeleteMapping("/deletecity/{id}")
	public ResponseEntity<MessageResponse> deleteCity(@PathVariable(value = "id") Long cityId)
			throws ResourceNotFoundException {
		if (addressService.deleteCity(cityId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addjob")
	public ResponseEntity<MessageResponse> addJob(@Valid @RequestBody JobDTO job) {
		if (jobService.addJobs(job))
			return ResponseEntity.ok().body(new MessageResponse(true, "Job added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Job not Successfully "));

	}

	@GetMapping("/getjobs")
	public ResponseEntity<List<JobDTO>> getJob() {
		return ResponseEntity.ok().body(jobService.getJobs());
	}
	@DeleteMapping("/deletejob/{id}")
	public ResponseEntity<MessageResponse> deleteJob(@PathVariable(value = "id") Long jobId)
			throws ResourceNotFoundException {
		if (jobService.deleteJob(jobId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addjobtitle")
	public ResponseEntity<MessageResponse> addJobTitle(@Valid @RequestBody JobTitleDTO jobTitle) {
		if (jobService.addJobTitles(jobTitle))
			return ResponseEntity.ok().body(new MessageResponse(true, "Job Title added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Job Title not Successfully "));

	}

	@GetMapping("/getjobtitles")
	public ResponseEntity<List<JobTitleDTO>> getJobTitle() {
		return ResponseEntity.ok().body(jobService.getJobTitles());
	}

	@DeleteMapping("/deletejobtitle/{id}")
	public ResponseEntity<MessageResponse> deleteJobTitle(@PathVariable(value = "id") Long jobTitleId)
			throws ResourceNotFoundException {
		if (jobService.deleteJobTitle(jobTitleId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	
	@PostMapping("/addeducation")
	public ResponseEntity<MessageResponse> addEducation(@Valid @RequestBody EducationDTO education) {
		if (educationService.addEducations(education))
			return ResponseEntity.ok().body(new MessageResponse(true, "Education added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Education not Successfully "));

	}

	@GetMapping("/geteducations")
	public ResponseEntity<List<EducationDTO>> getEducations() {
		return ResponseEntity.ok().body(educationService.getEducations());
	}
	@DeleteMapping("/deleteeducation/{id}")
	public ResponseEntity<MessageResponse> deleteEducation(@PathVariable(value = "id") Long educationId)
			throws ResourceNotFoundException {
		if (educationService.deleteEducation(educationId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	
	@PostMapping("/addcourse")
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
	@DeleteMapping("/deletecourse/{id}")
	public ResponseEntity<MessageResponse> deleteCourse(@PathVariable(value = "id") Long courseId)
			throws ResourceNotFoundException {
		if (courseService.deleteCourse(courseId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
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
	@DeleteMapping("/deletebusiness/{id}")
	public ResponseEntity<MessageResponse> deleteBusiness(@PathVariable(value = "id") Long businessId)
			throws ResourceNotFoundException {
		if (businessService.deleteBusiness(businessId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addRole")
	public ResponseEntity<MessageResponse> addRole(@Valid @RequestBody RoleDTO roleDto) {
		if (roleService.addRoles(roleDto))
			return ResponseEntity.ok().body(new MessageResponse(true, "Role added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Role not Successfully "));

	}

	@GetMapping("/getroles")
	public ResponseEntity<List<RoleDTO>> getRoles() {
		return ResponseEntity.ok().body(roleService.getRoles());
	}

	@PostMapping("/addbloodgroup")
	public ResponseEntity<MessageResponse> addBloodGroup(@Valid @RequestBody BloodGroupDTO bloodGroup) {
		if (personService.addBloodGroup(bloodGroup))
			return ResponseEntity.ok().body(new MessageResponse(true, "BloodGroup added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " BloodGroup not Successfully "));

	}

	@GetMapping("/getbloodgroups")
	public ResponseEntity<List<BloodGroupDTO>> getBloodGroups() {
		return ResponseEntity.ok().body(personService.getBloodGroups());
	}
	@DeleteMapping("/deletebloodgroup/{id}")
	public ResponseEntity<MessageResponse> deleteBloodGroup(@PathVariable(value = "id") Long bloodGroupId)
			throws ResourceNotFoundException {
		if (personService.deleteBloodGroup(bloodGroupId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
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

	@GetMapping("/getoperatortypes")
	public ResponseEntity<List<EOperator>> getOpeatorTypes() {
		return ResponseEntity.ok().body(enumService.getOperatorType());
	}
}
