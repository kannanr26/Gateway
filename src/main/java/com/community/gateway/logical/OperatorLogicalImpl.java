package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.OperatorMapper;
import com.community.gateway.model.Operator;
import com.community.gateway.service.OperatorService;

@Service
public class OperatorLogicalImpl implements OperatorLogical {

	@Autowired
	OperatorService operatorService;
	
	@Autowired
	OperatorMapper operatorMapper;

	@Override
	public List<OperatorDTO> findAll() {
		// TODO Auto-generated method stub
		return operatorMapper.toOperatorsDTOs(operatorService.findAll());
	}

	@Override
	public OperatorDTO findById(Long operatorId) throws ResourceNotFoundException {
		return operatorMapper.toOperatorsDTO(operatorService.findById(operatorId));
	}

	@Override
	public OperatorDTO save(@Valid OperatorDTO operatorDto) {
		// TODO Auto-generated method stub
		return operatorMapper.toOperatorsDTO(operatorService.save(operatorMapper.toOperator(operatorDto)));
		
	}

	@Override
	public void delete(Long operatorId)throws ResourceNotFoundException {
		operatorService.delete(operatorId);

	}

	@Override
	public OperatorDTO findByMobileNumber(long mobileNumber) throws ResourceNotFoundException {
		return operatorMapper.toOperatorsDTO(operatorService.findByMobileNumber(mobileNumber));
	}

	/*
	 * @Override public OperatorDTO findByMobileNumber(int number) throws
	 * ResourceNotFoundException { // TODO Auto-generated method stub return null; }
	 */

}
