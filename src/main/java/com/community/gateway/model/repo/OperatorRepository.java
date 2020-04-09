package com.community.gateway.model.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.community.gateway.model.Operator;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {

	Optional<Operator> findByMobileNumber(int mobileNumber);
	
	
	
	
}
