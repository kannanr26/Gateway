package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.EducationDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.EducationLogical;

@Service
public class EducationUtilService {

	private static final List<EducationDTO> educations = new ArrayList<EducationDTO>();

	private final EducationLogical educationLocial;

	@Autowired
	public EducationUtilService(EducationLogical educationLocial) {

		this.educationLocial = educationLocial;
	}


	public List<EducationDTO> getEducations() {
		if (educations.isEmpty()) {
			educations.addAll(educationLocial.findAll());
		}
		return educations;
	}

	public boolean addEducations(EducationDTO educationDTO) {
		if (getEducations().stream().noneMatch(x -> x.getEducationName().equalsIgnoreCase(educationDTO.getEducationName()))) {
			EducationDTO education = educationLocial.save(educationDTO);
			educations.add(education);
			return true;
		}
		return false;

	}

	public boolean deleteEducation(Long educationId) {
		 try {
			 educations.remove(educationLocial.findById(educationId));
			 educationLocial.delete(educationId);
			 
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
}