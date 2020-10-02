package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Deity;

@Repository
public interface DeityRepository extends CrudRepository<Deity, Long> {

	Iterable<Deity> findByCityId(Long cityId);

}
