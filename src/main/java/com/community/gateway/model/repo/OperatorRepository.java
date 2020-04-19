package com.community.gateway.model.repo;

import com.community.gateway.model.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {
	Optional<Operator> findByMobileNumber(long mobileNumber);

}
