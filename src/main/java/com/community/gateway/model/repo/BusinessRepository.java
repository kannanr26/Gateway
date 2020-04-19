package com.community.gateway.model.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Business;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Long> {

	Optional<Business> findByBusinessName(String businessName);

}
