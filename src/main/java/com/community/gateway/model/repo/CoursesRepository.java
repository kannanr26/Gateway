package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Courses;

@Repository
public interface CoursesRepository extends CrudRepository<Courses, Long> {

}
