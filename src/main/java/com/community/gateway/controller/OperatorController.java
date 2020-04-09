package com.community.gateway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.logical.OperatorLogical;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gateway")
public class OperatorController {

	@Autowired
	private OperatorLogical operatorL;

	@GetMapping("/operators")
	public List<OperatorDTO> getAllOperator() {
		return operatorL.findAll();
	}

	@GetMapping("/operator/{id}")
	public ResponseEntity<OperatorDTO> getOperatorById(@PathVariable(value = "id") Long operatorId)
			throws ResourceNotFoundException {
		OperatorDTO operator = null;
		try {
			operator = operatorL.findById(operatorId);
		} catch (com.community.gateway.exception.ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ResponseEntity.ok().body(operator);
	}

	@PostMapping("/operator")
	public OperatorDTO createOperator(@Valid @RequestBody OperatorDTO operator) {
		return operatorL.save(operator);
	}

	@PutMapping("/operator/{id}")
	public ResponseEntity<OperatorDTO> updateOperator(@PathVariable(value = "id") Long operatorId,
			@Valid @RequestBody OperatorDTO operator) throws ResourceNotFoundException {
		OperatorDTO operatorTOUpdate = null ;
		try {
			operatorTOUpdate = operatorL.findById(operatorId);
		} catch (com.community.gateway.exception.ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		operatorTOUpdate=operator;
	
		final OperatorDTO updatedOperator= operatorL.save(operatorTOUpdate);
		return ResponseEntity.ok(updatedOperator);
	}

	@DeleteMapping("/operator/{id}")
	public Map<String, Boolean> deleteOperator(@PathVariable(value = "id") Long operatorId)  throws ResourceNotFoundException
			 {
		//Operator operator = operatorL.findById(operatorId);
		try {
			operatorL.delete(operatorId);
		} catch (com.community.gateway.exception.ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
