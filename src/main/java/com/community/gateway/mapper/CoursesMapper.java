package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.CoursesDTO;
import com.community.gateway.model.Courses;
@Mapper(componentModel = "spring")
public interface CoursesMapper {
	CoursesDTO toCoursesDTO(Courses courses);

    List<CoursesDTO> toCoursesDTOs(List<Courses> courses);

    Courses toCourses(CoursesDTO coursesDTO);
}
