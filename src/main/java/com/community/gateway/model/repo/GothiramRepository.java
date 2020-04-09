package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Gothiram;

@Repository
public interface GothiramRepository extends CrudRepository<Gothiram, Long> {

}
