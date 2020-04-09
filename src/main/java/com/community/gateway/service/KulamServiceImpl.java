package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Kulam;
import com.community.gateway.model.repo.KulamRepository;

@Service
public class KulamServiceImpl implements KulamService {

	@Autowired
	KulamRepository kulamRepository;

	@Override
	public Kulam findById(Long kulamId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Kulam kulam = kulamRepository.findById(kulamId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + kulamId));
		return kulam;
	}

	@Override
	public List<Kulam> findAll() {
		List<Kulam> list = new ArrayList<>();
		Iterable<Kulam> customers = kulamRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long kulamId) {
		kulamRepository.deleteById(kulamId);

	}

	@Override
	public Kulam save(@Valid Kulam kulam) {
		// TODO Auto-generated method stub
		return kulamRepository.save(kulam);
	}
}
