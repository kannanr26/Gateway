package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.State;

public interface StateService {

	State findById(Long stateId) throws ResourceNotFoundException;

	List<State> findAll();

	void delete(Long stateId);

	State save(@Valid State state);

	List<State> findAllByCountryId(Long countryId);
}