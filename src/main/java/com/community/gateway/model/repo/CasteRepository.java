package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Caste;

@Repository
public interface CasteRepository extends CrudRepository<Caste, Long> {

}
