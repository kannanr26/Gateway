package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.BloodGroup;



@Repository
public interface BloodGroupRepository extends CrudRepository<BloodGroup, Long> {

}