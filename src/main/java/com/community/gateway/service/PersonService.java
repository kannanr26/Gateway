package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Person;

public interface PersonService {

	Person findById(Long personId) throws ResourceNotFoundException;

	List<Person> findAll();

	void delete(Long personId);

	Person save(@Valid Person person) throws Exception;
}
