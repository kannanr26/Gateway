package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Courses;

public interface CoursesService {
	Courses findById(Long coursesId) throws ResourceNotFoundException;

	List<Courses> findAll();

	void delete(Long coursesId);

	Courses save(@Valid Courses courses)throws ResourceNotFoundException;

	Courses findByCourseName(String courseName)throws ResourceNotFoundException;
}
