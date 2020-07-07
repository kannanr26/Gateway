package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.EducationDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
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

	public ResponseEntity<MessageResponse> addEducations(EducationDTO educationDTO) {
		try {
		if (getEducations().stream().noneMatch(x -> x.getEducationName().equalsIgnoreCase(educationDTO.getEducationName()))) {
			EducationDTO educationSaved = educationLocial.save(educationDTO);
			refreshEducation();
			if(educationDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(educationSaved,true,UtilityConstant.SUCCESS));
			else

				return ResponseEntity.ok().body(new MessageResponse(true,UtilityConstant.UPDATED_SUCCESS));
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
			return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));
	}

	public boolean deleteEducation(Long educationId) {
		 try {
			 educationLocial.delete(educationId);
			 refreshEducation();
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}


	private void refreshEducation() {
		// TODO Auto-generated method stub
		educations.clear();
		getEducations();
	}
}