package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.Operator_LoginDetailsDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.Operator_LoginDetailsMapper;
import com.community.gateway.model.Operator_LoginDetails;
import com.community.gateway.service.Operator_LoginDetailsService;

@Service
public class Operator_LoginDetailsLogicalImpl implements Operator_LoginDetailsLogical {

	@Autowired
	Operator_LoginDetailsService operator_logindetailsService;
	
	@Autowired
	Operator_LoginDetailsMapper operator_logindetailsMapper;

	@Override
	public List<Operator_LoginDetailsDTO> findAll() {
		// TODO Auto-generated method stub
		return operator_logindetailsMapper.toOperator_LoginDetailsDTOs(operator_logindetailsService.findAll());
	}

	@Override
	public Operator_LoginDetailsDTO findById(Long operator_logindetailsId) throws ResourceNotFoundException {
		return operator_logindetailsMapper.toOperator_LoginDetailsDTO(operator_logindetailsService.findById(operator_logindetailsId));
	}

	@Override
	public Operator_LoginDetailsDTO save(@Valid Operator_LoginDetailsDTO operator_logindetailsDto) {
		// TODO Auto-generated method stub
		return operator_logindetailsMapper.toOperator_LoginDetailsDTO(operator_logindetailsService.save(operator_logindetailsMapper.toOperator_LoginDetails(operator_logindetailsDto)));
		
	}

	@Override
	public void delete(Long operator_logindetailsId)throws ResourceNotFoundException {
		operator_logindetailsService.delete(operator_logindetailsId);

	}

}
