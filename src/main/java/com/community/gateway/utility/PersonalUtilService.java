package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BloodGroupDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.BloodGroupLogical;

@Service
public class PersonalUtilService {

	private static final List<BloodGroupDTO> bloodGroups = new ArrayList<BloodGroupDTO>();

	private final BloodGroupLogical bloodGroupLogical;

	@Autowired
	public PersonalUtilService(BloodGroupLogical bloodGroupLogical) {

		this.bloodGroupLogical = bloodGroupLogical;
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
}