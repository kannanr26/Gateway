package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.PersonDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.PersonMapper;
import com.community.gateway.model.Person;
import com.community.gateway.service.PersonService;

@Service
public class PersonLogicalImpl implements PersonLogical {

	@Autowired
	PersonService personService;
	
	@Autowired
	PersonMapper personMapper;

	@Override
	public List<PersonDTO> findAll() {
		// TODO Auto-generated method stub
		return personMapper.toPersonDTOs(personService.findAll());
	}

	@Override
	public PersonDTO findById(Long personId) throws ResourceNotFoundException {
		return personMapper.toPersonDTO(personService.findById(personId));
	}

	@Override
	public PersonDTO save(@Valid PersonDTO personDto) {
		// TODO Auto-generated method stub
		return personMapper.toPersonDTO(personService.save(personMapper.toPerson(personDto)));
		
	}

	@Override
	public void delete(Long personId)throws ResourceNotFoundException {
		personService.delete(personId);

	}

}
