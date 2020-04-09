package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.AddressDTO;
import com.community.gateway.model.Address;
@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO toAddressDTO(Address address);

    List<AddressDTO> toAddressDTOs(List<Address> address);

    Address toAddress(AddressDTO addressDTO);
}
