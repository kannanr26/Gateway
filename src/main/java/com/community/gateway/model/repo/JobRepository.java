package com.community.gateway.model.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

	Optional<Job> findByRoleName(String roleName);

}
