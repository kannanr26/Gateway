package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.community.gateway.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
	
	
	
	
}
