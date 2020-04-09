package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.AddressDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface AddressLogical {

	List<AddressDTO> findAll();

	AddressDTO findById(Long addressId)throws ResourceNotFoundException;

	//AddressDTO save(@Valid Address addressDTO);

	void delete(Long addressId) throws ResourceNotFoundException;

	AddressDTO save(@Valid AddressDTO addressDto);

}
