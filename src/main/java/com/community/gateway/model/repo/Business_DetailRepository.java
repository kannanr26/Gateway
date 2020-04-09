package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.community.gateway.model.Business_Detail;

@Repository
public interface Business_DetailRepository extends CrudRepository<Business_Detail, Long> {

}
