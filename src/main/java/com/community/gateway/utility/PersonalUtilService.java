package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.dto.MaritalStatusDTO;
import com.community.gateway.dto.RelationShipNameDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.BloodGroupLogical;
import com.community.gateway.logical.MaritalStatusLogical;
import com.community.gateway.logical.RelationshipNameLogical;

import ch.qos.logback.classic.pattern.Util;

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

	public ResponseEntity<MessageResponse> addBloodGroup(BloodGroupDTO bloodGroupDTO) {
		
		try{
			if (getBloodGroups().stream()	.noneMatch(x -> x.getBloodGroupName().equalsIgnoreCase(bloodGroupDTO.getBloodGroupName()))) { 
			BloodGroupDTO bloodGroupSaved = bloodGroupLogical.save(bloodGroupDTO);
			refreshBloodGroup();
			if(bloodGroupDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(bloodGroupSaved,true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));
	}

	private void refreshBloodGroup() {
		// TODO Auto-generated method stub
		bloodGroups.clear();
		bloodGroups.addAll(getBloodGroups());
	}

	public boolean deleteBloodGroup(Long bloodGroupId) {
		// TODO Auto-generated method stub
		try {
			bloodGroupLogical.delete(bloodGroupId);
			refreshBloodGroup();
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

	public ResponseEntity<MessageResponse> addMaritalStatus(MaritalStatusDTO maritalStatusDTO) {
		try{
			if (getMaritalStatuses().stream().noneMatch(x -> x.getMaritalStatusName().equalsIgnoreCase(maritalStatusDTO.getMaritalStatusName()))) { 
			MaritalStatusDTO maritalStatusSaved = maritalStatusLogical.save(maritalStatusDTO);
			refershMaritalStatus();
			if(maritalStatusDTO.getId()==0)
			return ResponseEntity.ok().body(new MessageResponse(maritalStatusSaved,true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));

	}

	private void refershMaritalStatus() {
		// TODO Auto-generated method stub
		maritalStatuses.clear();
		maritalStatuses.addAll(getMaritalStatuses());
	}

	public boolean deleteMaritalStatus(Long maritalStatusId) {
		// TODO Auto-generated method stub
		try {
			maritalStatusLogical.delete(maritalStatusId);
			refershMaritalStatus();
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

	public ResponseEntity<MessageResponse> addRelationshipName(RelationShipNameDTO relationshipNameDTO) {
		try {
		
		if (getRelationShipNames().stream()
				.noneMatch(x -> x.getRelationshipName().equalsIgnoreCase(relationshipNameDTO.getRelationshipName()))) { 
			RelationShipNameDTO relationshipNameNew = relationShipNamelogical.save(relationshipNameDTO);
			refreshRelationshipName();
			if(relationshipNameDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(relationshipNameNew,true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));

	}

	private void refreshRelationshipName() {
		// TODO Auto-generated method stub
		relationshipName.clear();
		relationshipName.addAll(getRelationShipNames());
	}

	public boolean deleteRelationshipName(Long relationshipNameId) {
		// TODO Auto-generated method stub
		try {
			relationShipNamelogical.delete(relationshipNameId);
			refreshRelationshipName();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}