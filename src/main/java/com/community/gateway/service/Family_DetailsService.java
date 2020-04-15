package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Family_Details;

public interface Family_DetailsService {

	Family_Details findById(Long family_detailsId) throws ResourceNotFoundException;

	List<Family_Details> findAll();

	void delete(Long family_detailsId);

	Family_Details save(@Valid Family_Details family_details)throws Exception;
}
