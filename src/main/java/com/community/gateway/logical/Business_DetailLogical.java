package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.Business_DetailDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface Business_DetailLogical {

	List<Business_DetailDTO> findAll();

	Business_DetailDTO findById(Long business_detailId)throws ResourceNotFoundException;

	//Business_DetailDTO save(@Valid Business_Detail business_detailDTO);

	void delete(Long business_detailId) throws ResourceNotFoundException;

	Business_DetailDTO save(@Valid Business_DetailDTO business_detailDto);

}
