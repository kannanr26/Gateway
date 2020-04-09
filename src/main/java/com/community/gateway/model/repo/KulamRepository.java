package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Kulam;

@Repository
public interface KulamRepository extends CrudRepository<Kulam, Long> {

}
