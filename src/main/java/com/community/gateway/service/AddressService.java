package com.community.gateway.service;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Address;

public interface AddressService {
	Address findById(Long addressId) throws ResourceNotFoundException;

	List<Address> findAll();

	void delete(Long addressId);

	Address save(@Valid Address address);
}
