package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.dto.AssociationCommitteeDTO;
import com.community.gateway.dto.PermissionDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.OperatorTypeLogical;
import com.community.gateway.logical.AssociationCommitteeLogical;
import com.community.gateway.logical.PermissionLogical;

@Service
public class ManagementUtilService {

	private static final List<OperatorTypeDTO> operatorType = new ArrayList<OperatorTypeDTO>();
	private static final List<AssociationCommitteeDTO> associationCommittees = new ArrayList<AssociationCommitteeDTO>();
	private static final List<PermissionDTO> permissions = new ArrayList<PermissionDTO>();

	private final PermissionLogical permissionLogical;
	private final AssociationCommitteeLogical associationCommitteeLogical;
	private final OperatorTypeLogical operatorTypeLogical;

	@Autowired
	public ManagementUtilService(OperatorTypeLogical dataUpdatorLogical,
			AssociationCommitteeLogical associationCommitteeLogical, PermissionLogical permissionLogical) {

		this.operatorTypeLogical = dataUpdatorLogical;
		this.associationCommitteeLogical = associationCommitteeLogical;
		this.permissionLogical = permissionLogical;
	}

	public List<OperatorTypeDTO> getOperatorTypes() {
		if (operatorType.isEmpty()) {
			operatorType.addAll(operatorTypeLogical.findAll());
		}
		return operatorType;
	}

	public ResponseEntity<MessageResponse> addOperatorType(OperatorTypeDTO operatorTypeDTO) {
		try {
			if (getOperatorTypes().stream()
					.noneMatch(x -> x.getOperatorTypeName().equalsIgnoreCase(operatorTypeDTO.getOperatorTypeName()))) {
				OperatorTypeDTO dataUpdatorSave = operatorTypeLogical.save(operatorTypeDTO);
				refreshOperatorType();
				if(operatorTypeDTO.getId()==0)
					return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.SUCCESS));
				else
					return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));

	}

	private void refreshOperatorType() {
		// TODO Auto-generated method stub
		operatorType.clear();
		operatorType.addAll(getOperatorTypes());
	}

	public boolean deleteOperatorType(Long dataUpdatorId) {
		// TODO Auto-generated method stub
		try {
			operatorTypeLogical.delete(dataUpdatorId);
			refreshOperatorType();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<AssociationCommitteeDTO> getAssociationCommittees() {
		if (associationCommittees.isEmpty()) {
			associationCommittees.addAll(associationCommitteeLogical.findAll());
		}
		return associationCommittees;
	}

	public ResponseEntity<MessageResponse> addAssociationCommittee(AssociationCommitteeDTO associationCommitteeDTO) {
		try {
			if (getAssociationCommittees().stream().noneMatch(x -> x.getAssociationCommitteeName()
					.equalsIgnoreCase(associationCommitteeDTO.getAssociationCommitteeName()))) {
				AssociationCommitteeDTO associationCommitteeSaved = associationCommitteeLogical.save(associationCommitteeDTO);
				refreshAssociationCommittee();
				if(associationCommitteeDTO.getId()==0)
					return ResponseEntity.ok().body(new MessageResponse(associationCommitteeSaved,true, UtilityConstant.SUCCESS));
				else
					return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
				
			}
		} catch (Exception e) {

		}
		
			return ResponseEntity.badRequest()
					.body(new MessageResponse(false, " AssociationCommittee not Successfully "));
	}

	private void refreshAssociationCommittee() {
		// TODO Auto-generated method stub
		associationCommittees.clear();
		associationCommittees.addAll(getAssociationCommittees());
	}

	public boolean deleteAssociationCommittee(Long associationCommitteeId) {
		// TODO Auto-generated method stub
		try {
			associationCommitteeLogical.delete(associationCommitteeId);
			refreshAssociationCommittee();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<PermissionDTO> getPermissions() {
		if (permissions.isEmpty()) {
			permissions.addAll(permissionLogical.findAll());
		}
		return permissions;
	}

	public ResponseEntity<MessageResponse> addPermission(PermissionDTO permissionDTO) {
		try {
			if (getPermissions().stream()
					.noneMatch(x -> x.getPermissionName().equalsIgnoreCase(permissionDTO.getPermissionName()))) {
				PermissionDTO permissionDTOSaved = permissionLogical.save(permissionDTO);
				refreshPermission();
				if (permissionDTO.getId() == 0)
					return ResponseEntity.ok()
							.body(new MessageResponse(permissionDTOSaved, true, UtilityConstant.SUCCESS));
				else
					return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));

			}
		} catch (Exception e) {

		}

		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));

	}

	private void refreshPermission() {
		// TODO Auto-generated method stub
		permissions.clear();
		permissions.addAll(getPermissions());
	}

	public boolean deletePermission(Long permissionId) {
		// TODO Auto-generated method stub
		try {
			permissionLogical.delete(permissionId);
			refreshPermission();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}