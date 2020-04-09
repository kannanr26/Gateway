package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.PersonalDetails;

@Repository
public interface PersonalDetailsRepository extends CrudRepository<PersonalDetails, Long> {

}
