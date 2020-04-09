package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Kulam;

public interface KulamService {

	Kulam findById(Long kulamId) throws ResourceNotFoundException;

	List<Kulam> findAll();

	void delete(Long kulamId);

	Kulam save(@Valid Kulam kulam);
}
