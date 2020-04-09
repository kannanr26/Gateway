package com.community.gateway.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Address;
import com.community.gateway.model.repo.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address findById(Long addressId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + addressId));
		return address;
	}

	@Override
	public List<Address> findAll() {
		List<Address> list = new ArrayList<>();
		Iterable<Address> customers = addressRepository.findAll();

		customers.forEach(list::add);
		return list;

	}

	@Override
	public void delete(Long addressId) {
		addressRepository.deleteById(addressId);

	}

	@Override
	public Address save(@Valid Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}
}
