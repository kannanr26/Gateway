package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Operator_Role;

@Repository
public interface Operator_RoleRepository extends CrudRepository<Operator_Role, Long> {

}
