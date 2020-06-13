package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.District;



@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {

}