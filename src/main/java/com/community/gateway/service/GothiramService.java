package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Gothiram;

public interface GothiramService {

	Gothiram findById(Long gothiramId) throws ResourceNotFoundException;

	List<Gothiram> findAll();

	void delete(Long gothiramId);

	Gothiram save(@Valid Gothiram gothiram);
}
