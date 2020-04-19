package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Courses;
import com.community.gateway.model.repo.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	CoursesRepository coursesRepository;

	@Override
	public Courses findById(Long coursesId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Courses courses = coursesRepository.findById(coursesId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + coursesId));
		return courses;
	}

	@Override
	public List<Courses> findAll() {
		List<Courses> list = new ArrayList<>();
		Iterable<Courses> customers = coursesRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long coursesId) {
		coursesRepository.deleteById(coursesId);

	}

	@Override
	public Courses save(@Valid Courses courses) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return coursesRepository.save(courses);
	}

	@Override
	public Courses findByCourseName(String courseName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Courses courses = coursesRepository.findByCourseName(courseName)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseName));
		return courses;
	}
}
