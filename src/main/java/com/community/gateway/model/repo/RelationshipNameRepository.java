package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.RelationshipName;

@Repository
public interface RelationshipNameRepository extends CrudRepository<RelationshipName, Long> {

}