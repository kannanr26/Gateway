package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.State;
import com.community.gateway.model.repo.StateRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;

	@Override
	public State findById(Long stateId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		State state = stateRepository.findById(stateId)
				.orElseThrow(() -> new ResourceNotFoundException("Blood not found for this id :: " + stateId));
		return state;
	}

	@Override
	public List<State> findAll() {
		List<State> list = new ArrayList<>();
		Iterable<State> customers = stateRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long stateId) {
		stateRepository.deleteById(stateId);

	}

	@Override
	public State save(@Valid State state) {
		// TODO Auto-generated method stub
		System.out.println(" state :"+state.getStateName());
		return stateRepository.save(state);
	}
}