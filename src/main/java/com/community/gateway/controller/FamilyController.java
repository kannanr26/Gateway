package com.community.gateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.Family_DetailsDTO;
import com.community.gateway.dto.PersonDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.Family_DetailsLogical;
import com.community.gateway.logical.PersonLogical;
import com.community.gateway.utility.UtilityConstant;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gateway")
public class FamilyController {

	@Autowired
	private Family_DetailsLogical familyL;

	@Autowired
	private PersonLogical personL;

	@PostMapping("/addGroup")
	public ResponseEntity<MessageResponse> create(@Valid @RequestBody Family_DetailsDTO family) {
		MessageResponse msgResp;
		try {
			familyL.save(family);
			msgResp = new MessageResponse(true, UtilityConstant.SUCCESS);
			return ResponseEntity.ok().body(msgResp);
		} catch (Exception e) {
			e.printStackTrace();
			msgResp = new MessageResponse(true, UtilityConstant.FAILED);
		}
		return ResponseEntity.badRequest().body(msgResp);
	}

/*	@PutMapping("/updateGroup{id}")
	public ResponseEntity<MessageResponse> updateGroup(@PathVariable(value = "id") Long familyId,
			@Valid @RequestBody Family_DetailsDTO family) throws ResourceNotFoundException {
		Family_DetailsDTO familyDtoUpdate = null;
		MessageResponse msgResp = null;
		try {
			familyDtoUpdate = familyL.findById(familyId);
		
		familyDtoUpdate = family;

		final Family_DetailsDTO updatedFamily = familyL.save(familyDtoUpdate);
	} catch (com.community.gateway.exception.ResourceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		msgResp = new MessageResponse(false, UtilityConstant.FAILED);
	} catch (Exception e) {
		e.printStackTrace();
		msgResp = new MessageResponse(false, UtilityConstant.FAILED);
	}

	return ResponseEntity.badRequest().body(msgResp);

	}*/

	@PostMapping("/addGroupPerson")
	public ResponseEntity<MessageResponse> createPerson(@PathVariable(value = "id") Long groupId,
			@Valid @RequestBody PersonDTO person) {
		MessageResponse msgResp;
		try {
			personL.save(person,groupId);
			msgResp = new MessageResponse(true, UtilityConstant.SUCCESS);
			return  ResponseEntity.ok().body(msgResp);
		} catch (Exception e) {
			e.printStackTrace();
			msgResp = new MessageResponse(true, UtilityConstant.FAILED);
		}
		return ResponseEntity.badRequest().body(msgResp);
	}

/*	@PutMapping("/updateGroup{id}")
	public ResponseEntity<MessageResponse> updatePerson(@PathVariable(value = "pid") Long personId, @Valid @RequestBody PersonDTO person)
			throws ResourceNotFoundException {
		PersonDTO personDtoUpdate = null;
		MessageResponse msgResp = null;
		try {
			personDtoUpdate = personL.findById(personId);
			personDtoUpdate = person;
//			if (personDtoUpdate.getFamilyDetails().getId() == groupId) {
//				//final PersonDTO updatedFamily = personL.update(personDtoUpdate,groupId);
//				//return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
//			}
		} catch (com.community.gateway.exception.ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msgResp = new MessageResponse(false, UtilityConstant.FAILED);
		} catch (Exception e) {
			e.printStackTrace();
			msgResp = new MessageResponse(false, UtilityConstant.FAILED);
		}

		return ResponseEntity.badRequest().body(msgResp);
	}*/
}
