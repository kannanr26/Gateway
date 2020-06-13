package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.AssociationCommitteeDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.AssociationCommitteeMapper;
import com.community.gateway.service.AssociationCommitteeService;

@Service
public class AssociationCommitteeLogicalImpl implements AssociationCommitteeLogical {

	@Autowired
	AssociationCommitteeService associationCommitteeService;
	
	@Autowired
	AssociationCommitteeMapper associationCommitteeMapper;

	@Override
	public List<AssociationCommitteeDTO> findAll() {
		// TODO Auto-generated method stub
		return associationCommitteeMapper.toAssociationCommitteeDTOs(associationCommitteeService.findAll());
	}

	@Override
	public AssociationCommitteeDTO findById(Long associationCommitteeId) throws ResourceNotFoundException {
		return associationCommitteeMapper.toAssociationCommitteeDTO(associationCommitteeService.findById(associationCommitteeId));
	}

	@Override
	public AssociationCommitteeDTO save(@Valid AssociationCommitteeDTO associationCommitteeDto) {
		// TODO Auto-generated method stub
		System.out.println(" associationCommitteeDto :"+associationCommitteeDto.getAssociationCommitteeName());
		return associationCommitteeMapper.toAssociationCommitteeDTO(associationCommitteeService.save(associationCommitteeMapper.toAssociationCommittee(associationCommitteeDto)));
		
	}

	@Override
	public void delete(Long associationCommitteeId)throws ResourceNotFoundException {
		associationCommitteeService.delete(associationCommitteeId);

	}

}