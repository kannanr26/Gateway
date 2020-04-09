package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Occupation_Detail;

public interface Occupation_DetailService {

	Occupation_Detail findById(Long occupation_detailId) throws ResourceNotFoundException;

	List<Occupation_Detail> findAll();

	void delete(Long occupation_detailId);

	Occupation_Detail save(@Valid Occupation_Detail occupation_detail);
}
