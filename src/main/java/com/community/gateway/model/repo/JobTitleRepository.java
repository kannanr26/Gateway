package com.community.gateway.model.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.JobTitle;

@Repository
public interface JobTitleRepository extends CrudRepository<JobTitle, Long> {

	Optional<JobTitle> findByJobTitleName(String jobTitleName);

}
