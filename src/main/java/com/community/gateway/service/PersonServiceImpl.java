package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Person;
import com.community.gateway.model.repo.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public Person findById(Long personId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + personId));
		return person;
	}

	@Override
	public List<Person> findAll() {
		List<Person> list = new ArrayList<>();
		Iterable<Person> customers = personRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long personId) {
		personRepository.deleteById(personId);

	}

	@Override
	public Person save(@Valid Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}
}
