package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Business_Detail;

public interface Business_DetailService {

	Business_Detail findById(Long business_detailId) throws ResourceNotFoundException;

	List<Business_Detail> findAll();

	void delete(Long business_detailId);

	Business_Detail save(@Valid Business_Detail business_detail);
}
