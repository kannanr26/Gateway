package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.OperatorType;



@Repository
public interface OperatorTypeRepository extends CrudRepository<OperatorType, Long> {

}