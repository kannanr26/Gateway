package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.JobTitle;

@Repository
public interface JobTitleRepository extends CrudRepository<JobTitle, Long> {

}
