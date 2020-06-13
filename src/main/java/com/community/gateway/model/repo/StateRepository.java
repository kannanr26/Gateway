package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.State;



@Repository
public interface StateRepository extends CrudRepository<State, Long> {

}