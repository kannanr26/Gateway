package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Permission;



@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {

}