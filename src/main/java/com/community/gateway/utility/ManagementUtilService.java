package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.dto.AssociationCommitteeDTO;
import com.community.gateway.dto.PermissionDTO;
import com.community.gateway.exception.ResourceNotFoundException;
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
	public ManagementUtilService(OperatorTypeLogical dataUpdatorLogical,AssociationCommitteeLogical associationCommitteeLogical,PermissionLogical permissionLogical) {

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

	public boolean addOperatorType(OperatorTypeDTO operatorTypeDTO) {
		if (getOperatorTypes().stream()
				.noneMatch(x -> x.getOperatorTypeName().equalsIgnoreCase(operatorTypeDTO.getOperatorTypeName()))) { 
			OperatorTypeDTO dataUpdator = operatorTypeLogical.save(operatorTypeDTO);
			operatorType.add(dataUpdator);
			return true;
		}
		return false;
	}

	public boolean deleteOperatorType(Long dataUpdatorId) {
		// TODO Auto-generated method stub
		try {
			operatorType.remove(operatorTypeLogical.findById(dataUpdatorId));
			operatorTypeLogical.delete(dataUpdatorId);
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

	public boolean addAssociationCommittee(AssociationCommitteeDTO associationCommitteeDTO) {
		if (getAssociationCommittees().stream()
				.noneMatch(x -> x.getAssociationCommitteeName().equalsIgnoreCase(associationCommitteeDTO.getAssociationCommitteeName()))) { 
			AssociationCommitteeDTO associationCommittee = associationCommitteeLogical.save(associationCommitteeDTO);
			associationCommittees.add(associationCommittee);
			return true;
		}
		return false;
	}

	public boolean deleteAssociationCommittee(Long associationCommitteeId) {
		// TODO Auto-generated method stub
		try {
			associationCommittees.remove(associationCommitteeLogical.findById(associationCommitteeId));
			associationCommitteeLogical.delete(associationCommitteeId);
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

	public boolean addPermission(PermissionDTO permissionDTO) {
		if (getPermissions().stream()
				.noneMatch(x -> x.getPermissionName().equalsIgnoreCase(permissionDTO.getPermissionName()))) { 
			PermissionDTO permission = permissionLogical.save(permissionDTO);
			permissions.add(permission);
			return true;
		}
		return false;
	}

	public boolean deletePermission(Long permissionId) {
		// TODO Auto-generated method stub
		try {
			permissions.remove(permissionLogical.findById(permissionId));
			permissionLogical.delete(permissionId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}