package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.OperatorTypeMapper;
import com.community.gateway.service.OperatorTypeService;

@Service
public class OperatorTypeLogicalImpl implements OperatorTypeLogical {

	@Autowired
	OperatorTypeService operatorTypeService;
	
	@Autowired
	OperatorTypeMapper operatorTypeMapper;

	@Override
	public List<OperatorTypeDTO> findAll() {
		// TODO Auto-generated method stub
		return operatorTypeMapper.toOperatorTypeDTOs(operatorTypeService.findAll());
	}

	@Override
	public OperatorTypeDTO findById(Long dataUpdatorId) throws ResourceNotFoundException {
		return operatorTypeMapper.toOperatorTypeDTO(operatorTypeService.findById(dataUpdatorId));
	}

	@Override
	public OperatorTypeDTO save(@Valid OperatorTypeDTO operatorTypeDto) {
		// TODO Auto-generated method stub
		System.out.println(" operatorTypeDto :"+operatorTypeDto.getOperatorTypeName());
		return operatorTypeMapper.toOperatorTypeDTO(operatorTypeService.save(operatorTypeMapper.toOperatorType(operatorTypeDto)));
		
	}

	@Override
	public void delete(Long dataUpdatorId)throws ResourceNotFoundException {
		operatorTypeService.delete(dataUpdatorId);

	}

}