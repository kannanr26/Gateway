package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.CoursesMapper;
import com.community.gateway.model.Courses;
import com.community.gateway.service.CoursesService;

@Service
public class CoursesLogicalImpl implements CoursesLogical {

	@Autowired
	CoursesService coursesService;
	
	@Autowired
	CoursesMapper coursesMapper;

	@Override
	public List<CoursesDTO> findAll() {
		// TODO Auto-generated method stub
		return coursesMapper.toCoursesDTOs(coursesService.findAll());
	}

	@Override
	public CoursesDTO findById(Long coursesId) throws ResourceNotFoundException {
		return coursesMapper.toCoursesDTO(coursesService.findById(coursesId));
	}

	@Override
	public CoursesDTO save(@Valid CoursesDTO coursesDto) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return coursesMapper.toCoursesDTO(coursesService.save(coursesMapper.toCourses(coursesDto)));
		
	}

	@Override
	public void delete(Long coursesId)throws ResourceNotFoundException {
		coursesService.delete(coursesId);

	}

	@Override
	public CoursesDTO findByCourseName(String courseName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return coursesMapper.toCoursesDTO(coursesService.findByCourseName(courseName));
	}

}
