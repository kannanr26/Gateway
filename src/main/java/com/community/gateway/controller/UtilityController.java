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

import com.community.gateway.dto.AssociationCommitteeDTO;
import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.dto.PermissionDTO;
import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.dto.StateDTO;
import com.community.gateway.dto.CountryDTO;
import com.community.gateway.dto.MaritalStatusDTO;
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
import com.community.gateway.utility.ManagementUtilService;

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
	private final ManagementUtilService managementService;

	@Autowired
	public UtilityController(FamilyUtilService familyService, AddressUtilService addressService,
			BusinessUtilService businessService, CoursesUtilService coursesService,
			EducationUtilService educationService, JobUtilService jobService, RoleUtilService roleService,
			EnumUtilService enumService,PersonalUtilService personService,ManagementUtilService managementService) {
		this.familyService = familyService;
		this.addressService = addressService;
		this.businessService = businessService;
		this.courseService = coursesService;
		this.educationService = educationService;
		this.jobService = jobService;
		this.roleService = roleService;
		this.personService=personService;
		this.enumService = enumService;
		this.managementService=managementService;
	}

	@PostMapping("/addKulam")
	public ResponseEntity<MessageResponse> addKulam(@Valid @RequestBody KulamDTO kulam) {
		System.out.println(" Before if ");
		if (familyService.addKulams(kulam)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Kulam added Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Kulam not Successfully "));

	}

	/*
	 * @PutMapping("/putkulam/{id}")
	 * 
	 * public ResponseEntity<MessageResponse> editKulam(@PathVariable(value = "id")
	 * Long kulamId,
	 * 
	 * @RequestBody KulamDTO kulam) { System.out.println(" Before if "); if
	 * (familyService.addKulams(kulam)) { System.out.println(" in If "); return
	 * ResponseEntity.ok().body(new MessageResponse(true,
	 * "Kulam added Successfully ")); } else return
	 * ResponseEntity.badRequest().body(new MessageResponse(false,
	 * "Kulam not Successfully "));
	 * 
	 * }
	 */
	@DeleteMapping("/deleteKulam/{id}")
	public ResponseEntity<MessageResponse> deleteKulam(@PathVariable(value = "id") Long kulamId)
			throws ResourceNotFoundException {
		if (familyService.deleteKulams(kulamId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Not deleted Successfully "));
	}

	@GetMapping("/getKulams")
	public ResponseEntity<List<KulamDTO>> getKulams() {
		return ResponseEntity.ok().body(familyService.getKulams());
	}

	@PostMapping("/addGothiram")
	public ResponseEntity<MessageResponse> addGothiram(@Valid @RequestBody GothiramDTO gothirams) {
		if (familyService.addGothirams(gothirams))
			return ResponseEntity.ok().body(new MessageResponse(true, "Gothiram added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Gothiram not Successfully "));

	}

	@GetMapping("/getGothirams")
	public ResponseEntity<List<GothiramDTO>> getGothirams() {
		return ResponseEntity.ok().body(familyService.getGothirams());
	}

	@DeleteMapping("/deleteGothiram/{id}")
	public ResponseEntity<MessageResponse> deleteGothiram(@PathVariable(value = "id") Long gothiramId)
			throws ResourceNotFoundException {
		if (familyService.deleteGothiram(gothiramId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	
	@PostMapping("/addDeity")
	public ResponseEntity<MessageResponse> addDeity(@Valid @RequestBody DeityDTO deity) {
		if (familyService.addDeitys(deity))
			return ResponseEntity.ok().body(new MessageResponse(true, "Deity added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deity not Successfully "));
	}

	@GetMapping("/getDeitys")
	public ResponseEntity<List<DeityDTO>> getDeitys() {
		return ResponseEntity.ok().body(familyService.getDeitys());
	}

	@DeleteMapping("/deleteDeity/{id}")
	public ResponseEntity<MessageResponse> deleteDeity(@PathVariable(value = "id") Long deityId)
			throws ResourceNotFoundException {
		if (familyService.deleteDeity(deityId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addCity")
	public ResponseEntity<MessageResponse> addCity(@Valid @RequestBody CityDTO city) {
		if (addressService.addCities(city))
			return ResponseEntity.ok().body(new MessageResponse(true, "City added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "City not Successfully "));

	}

	@GetMapping("/getCitys")
	public ResponseEntity<List<CityDTO>> getCity() {
		return ResponseEntity.ok().body(addressService.getCities());
	}

	@DeleteMapping("/deleteCity/{id}")
	public ResponseEntity<MessageResponse> deleteCity(@PathVariable(value = "id") Long cityId)
			throws ResourceNotFoundException {
		if (addressService.deleteCity(cityId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addJob")
	public ResponseEntity<MessageResponse> addJob(@Valid @RequestBody JobDTO job) {
		if (jobService.addJobs(job))
			return ResponseEntity.ok().body(new MessageResponse(true, "Job added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Job not Successfully "));

	}

	@GetMapping("/getJobs")
	public ResponseEntity<List<JobDTO>> getJob() {
		return ResponseEntity.ok().body(jobService.getJobs());
	}
	@DeleteMapping("/deleteJob/{id}")
	public ResponseEntity<MessageResponse> deleteJob(@PathVariable(value = "id") Long jobId)
			throws ResourceNotFoundException {
		if (jobService.deleteJob(jobId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addJobTitle")
	public ResponseEntity<MessageResponse> addJobTitle(@Valid @RequestBody JobTitleDTO jobTitle) {
		if (jobService.addJobTitles(jobTitle))
			return ResponseEntity.ok().body(new MessageResponse(true, "Job Title added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Job Title not Successfully "));

	}

	@GetMapping("/getJobTitles")
	public ResponseEntity<List<JobTitleDTO>> getJobTitle() {
		return ResponseEntity.ok().body(jobService.getJobTitles());
	}

	@DeleteMapping("/deleteJobTitle/{id}")
	public ResponseEntity<MessageResponse> deleteJobTitle(@PathVariable(value = "id") Long jobTitleId)
			throws ResourceNotFoundException {
		if (jobService.deleteJobTitle(jobTitleId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	
	@PostMapping("/addEducation")
	public ResponseEntity<MessageResponse> addEducation(@Valid @RequestBody EducationDTO education) {
		if (educationService.addEducations(education))
			return ResponseEntity.ok().body(new MessageResponse(true, "Education added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Education not Successfully "));

	}

	@GetMapping("/getEducations")
	public ResponseEntity<List<EducationDTO>> getEducations() {
		return ResponseEntity.ok().body(educationService.getEducations());
	}
	@DeleteMapping("/deleteEducation/{id}")
	public ResponseEntity<MessageResponse> deleteEducation(@PathVariable(value = "id") Long educationId)
			throws ResourceNotFoundException {
		if (educationService.deleteEducation(educationId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	
	@PostMapping("/addCourse")
	public ResponseEntity<MessageResponse> addCourse(@Valid @RequestBody CoursesDTO courses) {
		if (courseService.addCourses(courses))
			return ResponseEntity.ok().body(new MessageResponse(true, "Course added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Course not Successfully "));

	}

	@GetMapping("/getCourses")
	public ResponseEntity<List<CoursesDTO>> getCourses() {
		return ResponseEntity.ok().body(courseService.getCourses());
	}
	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<MessageResponse> deleteCourse(@PathVariable(value = "id") Long courseId)
			throws ResourceNotFoundException {
		if (courseService.deleteCourse(courseId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addBusiness")
	public ResponseEntity<MessageResponse> addBusiness(@Valid @RequestBody BusinessDTO business) {
		if (businessService.addbusiness(business))
			return ResponseEntity.ok().body(new MessageResponse(true, "Business added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " Business not Successfully "));

	}

	@GetMapping("/getBusiness")
	public ResponseEntity<List<BusinessDTO>> getBusiness() {
		return ResponseEntity.ok().body(businessService.getBusiness());
	}
	@DeleteMapping("/deleteBusiness/{id}")
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

	@GetMapping("/getRoles")
	public ResponseEntity<List<RoleDTO>> getRoles() {
		return ResponseEntity.ok().body(roleService.getRoles());
	}
	@DeleteMapping("/deleteRole/{id}")
	public ResponseEntity<MessageResponse> deleteRole(@PathVariable(value = "id") Long roleId)
			throws ResourceNotFoundException {
		if (roleService.deleteRole(roleId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	@PostMapping("/addBloodgroup")
	public ResponseEntity<MessageResponse> addBloodGroup(@Valid @RequestBody BloodGroupDTO bloodGroup) {
		if (personService.addBloodGroup(bloodGroup))
			return ResponseEntity.ok().body(new MessageResponse(true, "BloodGroup added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " BloodGroup not Successfully "));

	}

	@GetMapping("/getBloodgroups")
	public ResponseEntity<List<BloodGroupDTO>> getBloodGroups() {
		return ResponseEntity.ok().body(personService.getBloodGroups());
	}
	@DeleteMapping("/deleteBloodgroup/{id}")
	public ResponseEntity<MessageResponse> deleteBloodGroup(@PathVariable(value = "id") Long bloodGroupId)
			throws ResourceNotFoundException {
		if (personService.deleteBloodGroup(bloodGroupId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
	
	/*@GetMapping("/getOperatorTypes")
	public ResponseEntity<List<EOperator>> getOpeatorTypes() {
		return ResponseEntity.ok().body(enumService.getOperatorType());
	}
*/
	@PostMapping("/addMaritalStatus")
	public ResponseEntity<MessageResponse> addMaritalStatus(@Valid @RequestBody MaritalStatusDTO maritalStatus) {
		if (personService.addMaritalStatus(maritalStatus))
			return ResponseEntity.ok().body(new MessageResponse(true, "MaritalStatus added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " MaritalStatus not Successfully "));

	}

	@GetMapping("/getMaritalStatuses")
	public ResponseEntity<List<MaritalStatusDTO>> getMaritalStatuses() {
		return ResponseEntity.ok().body(personService.getMaritalStatuses());
	}

	@DeleteMapping("/deleteMaritalStatus/{id}")
	public ResponseEntity<MessageResponse> deleteMaritalStatus(@PathVariable(value = "id") Long maritalStatusId)
			throws ResourceNotFoundException {
		if (personService.deleteMaritalStatus(maritalStatusId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addCountry")
	public ResponseEntity<MessageResponse> addCountry(@Valid @RequestBody CountryDTO country) {
		if (addressService.addCountry(country))
			return ResponseEntity.ok().body(new MessageResponse(true, "Country added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " Country not Successfully "));

	}

	@GetMapping("/getCountries")
	public ResponseEntity<List<CountryDTO>> getCountries() {
		return ResponseEntity.ok().body(addressService.getCountries());
	}

	@DeleteMapping("/deleteCountry/{id}")
	public ResponseEntity<MessageResponse> deleteCountry(@PathVariable(value = "id") Long countryId)
			throws ResourceNotFoundException {
		if (addressService.deleteCountry(countryId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addState")
	public ResponseEntity<MessageResponse> addState(@Valid @RequestBody StateDTO state) {
		if (addressService.addState(state))
			return ResponseEntity.ok().body(new MessageResponse(true, "State added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " State not Successfully "));

	}

	@GetMapping("/getStates")
	public ResponseEntity<List<StateDTO>> getState() {
		return ResponseEntity.ok().body(addressService.getStates());
	}

	@DeleteMapping("/deleteState/{id}")
	public ResponseEntity<MessageResponse> deleteState(@PathVariable(value = "id") Long stateId)
			throws ResourceNotFoundException {
		if (addressService.deleteState(stateId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addDistrict")
	public ResponseEntity<MessageResponse> addDistrict(@Valid @RequestBody DistrictDTO district) {
		if (addressService.addDistrict(district))
			return ResponseEntity.ok().body(new MessageResponse(true, "District added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " District not Successfully "));

	}

	@GetMapping("/getDistricts")
	public ResponseEntity<List<DistrictDTO>> getDistrict() {
		return ResponseEntity.ok().body(addressService.getDistricts());
	}

	@DeleteMapping("/deleteDistrict/{id}")
	public ResponseEntity<MessageResponse> deleteDistrict(@PathVariable(value = "id") Long districtId)
			throws ResourceNotFoundException {
		if (addressService.deleteDistrict(districtId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addPermission")
	public ResponseEntity<MessageResponse> addPermission(@Valid @RequestBody PermissionDTO permission) {
		if (managementService.addPermission(permission))
			return ResponseEntity.ok().body(new MessageResponse(true, "Permission added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " Permission not Successfully "));

	}

	@GetMapping("/getPermissions")
	public ResponseEntity<List<PermissionDTO>> getPermissions() {
		return ResponseEntity.ok().body(managementService.getPermissions());
	}

	@DeleteMapping("/deletePermission/{id}")
	public ResponseEntity<MessageResponse> deletePermission(@PathVariable(value = "id") Long permissionId)
			throws ResourceNotFoundException {
		if (managementService.deletePermission(permissionId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addAssociationCommittee")
	public ResponseEntity<MessageResponse> addAssociationCommittee(@Valid @RequestBody AssociationCommitteeDTO associationCommittee) {
		if (managementService.addAssociationCommittee(associationCommittee))
			return ResponseEntity.ok().body(new MessageResponse(true, "AssociationCommittee added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " AssociationCommittee not Successfully "));

	}

	@GetMapping("/getAssociationCommittees")
	public ResponseEntity<List<AssociationCommitteeDTO>> getAssociationCommittees() {
		return ResponseEntity.ok().body(managementService.getAssociationCommittees());
	}
	@DeleteMapping("/deleteAssociationCommittee/{id}")
	public ResponseEntity<MessageResponse> deleteAssociationCommittee(@PathVariable(value = "id") Long associationCommitteeId)
			throws ResourceNotFoundException {
		if (managementService.deleteAssociationCommittee(associationCommitteeId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addOperatorType")
	public ResponseEntity<MessageResponse> addDataUpdator(@Valid @RequestBody OperatorTypeDTO dataUpdator) {
		if (managementService.addOperatorType(dataUpdator))
			return ResponseEntity.ok().body(new MessageResponse(true, "Operator Type added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, " Operator Type not Successfully "));

	}

	@GetMapping("/getOperatorTypes")
	public ResponseEntity<List<OperatorTypeDTO>> getDataUpdators() {
		return ResponseEntity.ok().body(managementService.getOperatorTypes());
	}
	@DeleteMapping("/deleteOperatorType/{id}")
	public ResponseEntity<MessageResponse> deleteOperatorType(@PathVariable(value = "id") Long operatorTypeId)
			throws ResourceNotFoundException {
		if (managementService.deleteOperatorType(operatorTypeId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}
}
