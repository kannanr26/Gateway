package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

}
