package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Operator_LoginDetails;

@Repository
public interface Operator_LoginDetailsRepository extends CrudRepository<Operator_LoginDetails, Long> {

}
