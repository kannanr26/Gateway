package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.community.gateway.model.Family_Details;

@Repository
public interface Family_DetailsRepository extends CrudRepository<Family_Details, Long> {
	
	
	
	
}
