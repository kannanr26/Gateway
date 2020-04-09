package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.PersonalDetails;

public interface PersonalDetailsService {

	PersonalDetails findById(Long personaldetailsId) throws ResourceNotFoundException;

	List<PersonalDetails> findAll();

	void delete(Long personaldetailsId);

	PersonalDetails save(@Valid PersonalDetails personaldetails);
}
