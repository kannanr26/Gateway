package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
