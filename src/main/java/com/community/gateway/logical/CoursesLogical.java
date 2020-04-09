package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface CoursesLogical {

	List<CoursesDTO> findAll();

	CoursesDTO findById(Long coursesId)throws ResourceNotFoundException;

	//CoursesDTO save(@Valid Courses coursesDTO);

	void delete(Long coursesId) throws ResourceNotFoundException;

	CoursesDTO save(@Valid CoursesDTO coursesDto);

}
