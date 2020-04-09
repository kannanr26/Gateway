package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.RelationShips;

@Repository
public interface RelationShipsRepository extends CrudRepository<RelationShips, Long> {

}
