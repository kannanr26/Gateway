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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.AssociationCommitteeDTO;
import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.dto.CasteDTO;
import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.CountryDTO;
import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.dto.EducationDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.dto.MaritalStatusDTO;
import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.dto.PermissionDTO;
import com.community.gateway.dto.RelationShipNameDTO;
import com.community.gateway.dto.RoleDTO;
import com.community.gateway.dto.StateDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.utility.AddressUtilService;
import com.community.gateway.utility.BusinessUtilService;
import com.community.gateway.utility.CoursesUtilService;
import com.community.gateway.utility.EducationUtilService;
import com.community.gateway.utility.FamilyUtilService;
import com.community.gateway.utility.JobUtilService;
import com.community.gateway.utility.ManagementUtilService;
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
	// private final EnumUtilService enumService;
	private final ManagementUtilService managementService;

	@Autowired
	public UtilityController(FamilyUtilService familyService, AddressUtilService addressService,
			BusinessUtilService businessService, CoursesUtilService coursesService,
			EducationUtilService educationService, JobUtilService jobService, RoleUtilService roleService,
			PersonalUtilService personService, ManagementUtilService managementService) {
		this.familyService = familyService;
		this.addressService = addressService;
		this.businessService = businessService;
		this.courseService = coursesService;
		this.educationService = educationService;
		this.jobService = jobService;
		this.roleService = roleService;
		this.personService = personService;
		// this.enumService = enumService;
		this.managementService = managementService;
	}

	@PostMapping("/addKulam")
	public ResponseEntity<MessageResponse> addKulam(@Valid @RequestBody KulamDTO kulam) {
		return familyService.addKulams(kulam);
	}

	@DeleteMapping("/deleteKulam/{id}")
	public ResponseEntity<MessageResponse> deleteKulam(@PathVariable(value = "id") Long kulamId)
			throws ResourceNotFoundException {
		if (familyService.deleteKulams(kulamId)) {
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
		return familyService.addGothirams(gothirams);

	}

	@GetMapping("/getGothirams")
	public ResponseEntity<List<GothiramDTO>> getGothirams() {
		return ResponseEntity.ok().body(familyService.getGothirams());
	}

	@DeleteMapping("/deleteGothiram/{id}")
	public ResponseEntity<MessageResponse> deleteGothiram(@PathVariable(value = "id") Long gothiramId)
			throws ResourceNotFoundException {
		if (familyService.deleteGothiram(gothiramId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addCaste")
	public ResponseEntity<MessageResponse> addCaste(@Valid @RequestBody CasteDTO caste) {
		return familyService.addCaste(caste);

	}

	@GetMapping("/getCastes")
	public ResponseEntity<List<CasteDTO>> getCastes() {
		return ResponseEntity.ok().body(familyService.getCastes());
	}

	@DeleteMapping("/deleteCaste/{id}")
	public ResponseEntity<MessageResponse> deleteCaste(@PathVariable(value = "id") Long casteId)
			throws ResourceNotFoundException {
		if (familyService.deleteCaste(casteId)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addDeity")
	public ResponseEntity<MessageResponse> addDeity(@Valid @RequestBody DeityDTO deity) {
		return familyService.addDeitys(deity);
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

	@PostMapping("/addJob")
	public ResponseEntity<MessageResponse> addJob(@Valid @RequestBody JobDTO job) {
		return jobService.addJobs(job);
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
		return jobService.addJobTitles(jobTitle);
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
		return educationService.addEducations(education);
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
		return courseService.addCourses(courses);

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
		return businessService.addbusiness(business);

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
		return roleService.addRoles(roleDto);

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
		return personService.addBloodGroup(bloodGroup);
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

	/*
	 * @GetMapping("/getOperatorTypes") public ResponseEntity<List<EOperator>>
	 * getOpeatorTypes() { return
	 * ResponseEntity.ok().body(enumService.getOperatorType()); }
	 */
	@PostMapping("/addRelationShipName")
	public ResponseEntity<MessageResponse> addRelationShipName(
			@Valid @RequestBody RelationShipNameDTO relationShipName) {
		return personService.addRelationshipName(relationShipName);
	}

	@GetMapping("/getRelationShipNames")
	public ResponseEntity<List<RelationShipNameDTO>> getRelationShipNames() {
		return ResponseEntity.ok().body(personService.getRelationShipNames());
	}

	@DeleteMapping("/deleteRelationShipName/{id}")
	public ResponseEntity<MessageResponse> deleteRelationShipName(@PathVariable(value = "id") Long RelationShipNameId)
			throws ResourceNotFoundException {
		if (personService.deleteRelationshipName(RelationShipNameId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addMaritalStatus")
	public ResponseEntity<MessageResponse> addMaritalStatus(@Valid @RequestBody MaritalStatusDTO maritalStatus) {
		return personService.addMaritalStatus(maritalStatus);
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

	@PostMapping("/addCity")
	public ResponseEntity<MessageResponse> addCity(@Valid @RequestBody CityDTO city) {
		return addressService.addCities(city);

	}

	@GetMapping("/getCitys/{id}")
	public ResponseEntity<List<CityDTO>> getCity(@PathVariable(value = "id") Long districtId) {
		return ResponseEntity.ok().body(addressService.getCities(districtId));
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

	@PostMapping("/addCountry")
	public ResponseEntity<MessageResponse> addCountry(@Valid @RequestBody CountryDTO country) {
		return addressService.addCountry(country);

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
		return addressService.addState(state);

	}

	@GetMapping("/getStates/{id}")
	public ResponseEntity<List<StateDTO>> getState(@PathVariable(value = "id") Long countryId) {
		return ResponseEntity.ok().body(addressService.getStates(countryId));
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
		return addressService.addDistrict(district);

	}

	@GetMapping("/getDistricts/{id}")
	public ResponseEntity<List<DistrictDTO>> getDistrict(@PathVariable(value = "id") Long stateId) {
		return ResponseEntity.ok().body(addressService.getDistricts(stateId));
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
		return managementService.addPermission(permission);
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
	public ResponseEntity<MessageResponse> addAssociationCommittee(
			@Valid @RequestBody AssociationCommitteeDTO associationCommittee) {
		return managementService.addAssociationCommittee(associationCommittee);
		

	}

	@GetMapping("/getAssociationCommittees")
	public ResponseEntity<List<AssociationCommitteeDTO>> getAssociationCommittees() {
		return ResponseEntity.ok().body(managementService.getAssociationCommittees());
	}

	@DeleteMapping("/deleteAssociationCommittee/{id}")
	public ResponseEntity<MessageResponse> deleteAssociationCommittee(
			@PathVariable(value = "id") Long associationCommitteeId) throws ResourceNotFoundException {
		if (managementService.deleteAssociationCommittee(associationCommitteeId)) {
			return ResponseEntity.ok().body(new MessageResponse(true, "Deleted Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deleted not Successfully "));
	}

	@PostMapping("/addOperatorType")
	public ResponseEntity<MessageResponse> addDataUpdator(@Valid @RequestBody OperatorTypeDTO dataUpdator) {
		return managementService.addOperatorType(dataUpdator);
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
