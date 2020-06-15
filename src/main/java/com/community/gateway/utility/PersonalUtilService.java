package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.dto.MaritalStatusDTO;
import com.community.gateway.dto.RelationShipNameDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.BloodGroupLogical;
import com.community.gateway.logical.MaritalStatusLogical;
import com.community.gateway.logical.RelationshipNameLogical;

@Service
public class PersonalUtilService {

	private static final List<BloodGroupDTO> bloodGroups = new ArrayList<BloodGroupDTO>();
	private static final List<MaritalStatusDTO> maritalStatuses = new ArrayList<MaritalStatusDTO>();
	private static final List<RelationShipNameDTO> relationshipName = new ArrayList<RelationShipNameDTO>();

	private final BloodGroupLogical bloodGroupLogical;
	private final MaritalStatusLogical maritalStatusLogical;
	private final RelationshipNameLogical relationShipNamelogical;

	@Autowired
	public PersonalUtilService(BloodGroupLogical bloodGroupLogical,MaritalStatusLogical maritalStatusLogical,RelationshipNameLogical relationShipNamelogical) {

		this.bloodGroupLogical = bloodGroupLogical;
		this.maritalStatusLogical = maritalStatusLogical;
		this.relationShipNamelogical=relationShipNamelogical;
	}

	public List<BloodGroupDTO> getBloodGroups() {
		if (bloodGroups.isEmpty()) {
			bloodGroups.addAll(bloodGroupLogical.findAll());
		}
		return bloodGroups;
	}

	public boolean addBloodGroup(BloodGroupDTO bloodGroupDTO) {
		if (getBloodGroups().stream()
				.noneMatch(x -> x.getBloodGroupName().equalsIgnoreCase(bloodGroupDTO.getBloodGroupName()))) { 
			BloodGroupDTO bloodGroup = bloodGroupLogical.save(bloodGroupDTO);
			bloodGroups.add(bloodGroup);
			return true;
		}
		return false;
	}

	public boolean deleteBloodGroup(Long bloodGroupId) {
		// TODO Auto-generated method stub
		try {
			bloodGroups.remove(bloodGroupLogical.findById(bloodGroupId));
			bloodGroupLogical.delete(bloodGroupId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<MaritalStatusDTO> getMaritalStatuses() {
		if (maritalStatuses.isEmpty()) {
			maritalStatuses.addAll(maritalStatusLogical.findAll());
		}
		return maritalStatuses;
	}

	public boolean addMaritalStatus(MaritalStatusDTO maritalStatusDTO) {
		if (getMaritalStatuses().stream()
				.noneMatch(x -> x.getMaritalStatusName().equalsIgnoreCase(maritalStatusDTO.getMaritalStatusName()))) { 
			MaritalStatusDTO maritalStatus = maritalStatusLogical.save(maritalStatusDTO);
			maritalStatuses.add(maritalStatus);
			return true;
		}
		return false;
	}

	public boolean deleteMaritalStatus(Long maritalStatusId) {
		// TODO Auto-generated method stub
		try {
			maritalStatuses.remove(maritalStatusLogical.findById(maritalStatusId));
			maritalStatusLogical.delete(maritalStatusId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<RelationShipNameDTO> getRelationShipNames() {
		if (relationshipName.isEmpty()) {
			relationshipName.addAll(relationShipNamelogical.findAll());
		}
		return relationshipName;
	}

	public boolean addRelationshipName(RelationShipNameDTO relationshipNameDTO) {
		if (getRelationShipNames().stream()
				.noneMatch(x -> x.getRelationshipName().equalsIgnoreCase(relationshipNameDTO.getRelationshipName()))) { 
			RelationShipNameDTO relationshipNameNew = relationShipNamelogical.save(relationshipNameDTO);
			relationshipName.add(relationshipNameNew);
			return true;
		}
		return false;
	}

	public boolean deleteRelationshipName(Long relationshipNameId) {
		// TODO Auto-generated method stub
		try {
			relationshipName.remove(relationShipNamelogical.findById(relationshipNameId));
			relationShipNamelogical.delete(relationshipNameId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}