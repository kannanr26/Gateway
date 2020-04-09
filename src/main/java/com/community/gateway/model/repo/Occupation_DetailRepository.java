package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Occupation_Detail;

@Repository
public interface Occupation_DetailRepository extends CrudRepository<Occupation_Detail, Long> {

}
