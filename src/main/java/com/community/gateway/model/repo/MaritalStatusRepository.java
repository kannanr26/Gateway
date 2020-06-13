package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.MaritalStatus;



@Repository
public interface MaritalStatusRepository extends CrudRepository<MaritalStatus, Long> {

}