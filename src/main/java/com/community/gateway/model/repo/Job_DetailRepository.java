package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Job_Detail;

@Repository
public interface Job_DetailRepository extends CrudRepository<Job_Detail, Long> {

}
