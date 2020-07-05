package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.RoleDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.RoleLogical;

@Service
public class RoleUtilService {

	private static final List<RoleDTO> roles = new ArrayList<RoleDTO>();
	// private static final List<Operator_RoleDTO> operatorRoles = new
	// ArrayList<RoleDTO>();
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

	public ResponseEntity<MessageResponse> addRoles(RoleDTO roleDTO) {
		try {
			if (getRoles().stream().noneMatch(x -> x.getRoleName().equalsIgnoreCase(roleDTO.getRoleName()))) {
				RoleDTO roleSaved = roleLocial.save(roleDTO);
				refreshRole();
				if (roleDTO.getId() == 0)
					return ResponseEntity.ok().body(new MessageResponse(roleSaved, true, UtilityConstant.SUCCESS));
				else
					return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
			}
		} catch (Exception e) {

		}
		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));

	}

	private void refreshRole() {
		// TODO Auto-generated method stub
		roles.clear();
		getRoles();
	}

	public boolean deleteRole(Long roleId) {
		// TODO Auto-generated method stub
		try {
			roleLocial.delete(roleId);
			refreshRole();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}