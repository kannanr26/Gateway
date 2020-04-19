package com.community.gateway.model.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {

	Optional<Education> findByEducationName(String educationName);

}
