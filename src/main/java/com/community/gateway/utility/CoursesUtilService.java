package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.exception.ResourceNotFoundException;
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

	public boolean addCourses(CoursesDTO coursesDTO) {
		if (getCourses().stream().noneMatch(x -> x.getCourseName().equalsIgnoreCase(coursesDTO.getCourseName()))) {
			CoursesDTO course;
			try {
				course = coursesLocial.save(coursesDTO);
				courses.add(course);
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		}
		return false;

	}


}