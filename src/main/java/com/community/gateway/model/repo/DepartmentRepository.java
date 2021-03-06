package com.community.gateway.model.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.community.gateway.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
