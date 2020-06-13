package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.RoleDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.RoleLogical;

@Service
public class RoleUtilService {

	private static final List<RoleDTO> roles = new ArrayList<RoleDTO>();
	//private static final List<Operator_RoleDTO> operatorRoles = new ArrayList<RoleDTO>();
	private final RoleLogical roleLocial;

	@Autowired
	public RoleUtilService(RoleLogical roleLocial) {

		this.roleLocial = roleLocial;
	}


	public List<RoleDTO> getRoles() {
		if (roles.isEmpty()) {
			roles.addAll(roleLocial.findAll());
		}
		return roles;
	}

	public boolean addRoles(RoleDTO roleDTO) {
		if (getRoles().stream().noneMatch(x -> x.getRoleName().equalsIgnoreCase(roleDTO.getRoleName()))) {
			RoleDTO role = roleLocial.save(roleDTO);
			roles.add(role);
			return true;
		}
		return false;

	}
	public boolean deleteRole(Long roleId) {
		// TODO Auto-generated method stub
		try {
			roles.remove(roleLocial.findById(roleId));
			roleLocial.delete(roleId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}