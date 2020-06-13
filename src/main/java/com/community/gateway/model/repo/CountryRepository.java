package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Country;



@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}