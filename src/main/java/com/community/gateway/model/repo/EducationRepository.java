package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {

}
