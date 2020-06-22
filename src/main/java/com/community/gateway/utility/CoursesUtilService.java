package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.CoursesLogical;

@Service
public class CoursesUtilService {

	private static final List<CoursesDTO> courses = new ArrayList<CoursesDTO>();

	private final CoursesLogical coursesLocial;

	@Autowired
	public CoursesUtilService(CoursesLogical coursesLocial) {

		this.coursesLocial = coursesLocial;
	}

	public List<CoursesDTO> getCourses() {
		if (courses.isEmpty()) {
			courses.addAll(coursesLocial.findAll());
		}
		return courses;
	}

	public ResponseEntity<MessageResponse> addCourses(CoursesDTO coursesDTO) {
		
		try {
			if (getCourses().stream().noneMatch(x -> x.getCourseName().equalsIgnoreCase(coursesDTO.getCourseName()))) {
			CoursesDTO	courseSaved = coursesLocial.save(coursesDTO);
			refreshCourse();
			if(coursesDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(courseSaved,true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
			
			} 
		}
		catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));


	}

	private void refreshCourse() {
		// TODO Auto-generated method stub
		courses.clear();
		courses.addAll(getCourses());
	}

	public boolean deleteCourse(Long courseId) {
		// TODO Auto-generated method stub
		try {
			coursesLocial.delete(courseId);
			refreshCourse();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}