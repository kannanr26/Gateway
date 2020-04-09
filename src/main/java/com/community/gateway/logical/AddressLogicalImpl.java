package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.AddressDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.AddressMapper;
import com.community.gateway.model.Address;
import com.community.gateway.service.AddressService;

@Service
public class AddressLogicalImpl implements AddressLogical {

	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressMapper addressMapper;

	@Override
	public List<AddressDTO> findAll() {
		// TODO Auto-generated method stub
		return addressMapper.toAddressDTOs(addressService.findAll());
	}

	@Override
	public AddressDTO findById(Long addressId) throws ResourceNotFoundException {
		return addressMapper.toAddressDTO(addressService.findById(addressId));
	}

	@Override
	public AddressDTO save(@Valid AddressDTO addressDto) {
		// TODO Auto-generated method stub
		return addressMapper.toAddressDTO(addressService.save(addressMapper.toAddress(addressDto)));
		
	}

	@Override
	public void delete(Long addressId)throws ResourceNotFoundException {
		addressService.delete(addressId);

	}

}
