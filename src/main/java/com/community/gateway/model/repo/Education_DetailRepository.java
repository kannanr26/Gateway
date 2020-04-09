package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Education_Detail;

@Repository
public interface Education_DetailRepository extends CrudRepository<Education_Detail, Long> {

}
