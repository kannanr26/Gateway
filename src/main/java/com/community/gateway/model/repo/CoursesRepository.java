package com.community.gateway.model.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Courses;

@Repository
public interface CoursesRepository extends CrudRepository<Courses, Long> {

	Optional<Courses> findByCourseName(String courseName);

}
