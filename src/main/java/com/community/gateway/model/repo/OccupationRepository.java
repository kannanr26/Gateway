package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Occupation;

@Repository
public interface OccupationRepository extends CrudRepository<Occupation, Long> {

}
