/**
 * 
 */
package com.community.gateway.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.community.gateway.model.Operator_Details;
import com.community.gateway.model.e_num.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.model.Operator;
import com.community.gateway.model.repo.OperatorRepository;

/**
 * @author deepikamalar
 *
 */
@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	OperatorRepository operatorRepository;
	@Override
	public Operator findById(Long operatorId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		Operator operator = operatorRepository.findById(operatorId)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this id :: " + operatorId));
		return operator;
	}

	@Override
	public List<Operator> findAll() {
		List<Operator> list = new ArrayList<>();
		Iterable<Operator> customers = operatorRepository.findAll();

		customers.forEach(list::add);
		return list;
		
	}

	@Override
	public void delete(Long operatorId) {
		operatorRepository.deleteById(operatorId);
		
	}

	@Override
	public Operator save(@Valid Operator operator) {
		// TODO Auto-generated method stub
		return operatorRepository.save(operator);
	}

	@Override
	public Operator findByMobileNumber(String mobileNumber) throws ResourceNotFoundException {
		if(operatorRepository.count()==0){
			Operator operator = new Operator();
			operator.setMobileNumber("1234567890");
			operator.setPassword("Password1");
			operatorRepository.save(operator);
		}

		Operator operator = operatorRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Operator not found for this mobileNumber :: " + mobileNumber));
//		Operator_Details operator_details= new Operator_Details();
//		operator_details.setRole(ERole.ROLE_ADMIN);
//		operator_details.setOperatorName("Op1");
//		operator_details.setCreatedTimestamp(new Date());
//		operator_details.setOperator(operator);
//		operator.setOperator_Details(operator_details);
		return operator;
	}

}
