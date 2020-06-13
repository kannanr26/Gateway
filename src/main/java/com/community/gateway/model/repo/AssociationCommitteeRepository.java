package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.AssociationCommittee;



@Repository
public interface AssociationCommitteeRepository extends CrudRepository<AssociationCommittee, Long> {

}