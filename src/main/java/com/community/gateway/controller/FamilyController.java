package com.community.gateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.Family_DetailsDTO;
import com.community.gateway.logical.Family_DetailsLogical;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gateway")
public class FamilyController {

	@Autowired
	private Family_DetailsLogical familyL;

	/*
	 * @GetMapping("/family/{id}") public ResponseEntity<OperatorDTO>
	 * getOperatorById(@PathVariable(value = "id") Long operatorId) throws
	 * ResourceNotFoundException { OperatorDTO operator = null; try { operator =
	 * operatorL.findById(operatorId); } catch
	 * (com.community.gateway.communitygateway.exception.ResourceNotFoundException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return ResponseEntity.ok().body(operator); }
	 */
	@PostMapping("/addfamily")
	public Family_DetailsDTO createOperator(@Valid @RequestBody Family_DetailsDTO family) {
		return familyL.save(family);
	}

	/*
	 * @PutMapping("/operator/{id}") public ResponseEntity<OperatorDTO>
	 * updateOperator(@PathVariable(value = "id") Long operatorId,
	 * 
	 * @Valid @RequestBody OperatorDTO operator) throws ResourceNotFoundException {
	 * OperatorDTO operatorTOUpdate = null ; try { operatorTOUpdate =
	 * operatorL.findById(operatorId); } catch
	 * (com.community.gateway.communitygateway.exception.ResourceNotFoundException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * operatorTOUpdate=operator;
	 * 
	 * final OperatorDTO updatedOperator= operatorL.save(operatorTOUpdate); return
	 * ResponseEntity.ok(updatedOperator); }
	 * 
	 * @DeleteMapping("/operator/{id}") public Map<String, Boolean>
	 * deleteOperator(@PathVariable(value = "id") Long operatorId) throws
	 * ResourceNotFoundException { //Operator operator =
	 * operatorL.findById(operatorId); try { operatorL.delete(operatorId); } catch
	 * (com.community.gateway.communitygateway.exception.ResourceNotFoundException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } Map<String,
	 * Boolean> response = new HashMap<>(); response.put("deleted", Boolean.TRUE);
	 * return response; }
	 */
}
