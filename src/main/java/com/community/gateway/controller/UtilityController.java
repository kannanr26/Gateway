package com.community.gateway.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.JobDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.utility.AddressService;
import com.community.gateway.utility.FamilyService;

@RestController
@RequestMapping("/gws")
public class UtilityController {

	private final FamilyService familyService;
	private final AddressService addressService;

	@Autowired
	public UtilityController(FamilyService familyService, AddressService addressService) {
		this.familyService = familyService;
		this.addressService = addressService;

	}

	@PostMapping("/util/addkulam")
	public ResponseEntity<MessageResponse> addKulam(@Valid @RequestBody KulamDTO kulam) {
		System.out.println(" Before if ");
		if (familyService.addKulams(kulam)) {
			System.out.println(" in If ");
			return ResponseEntity.ok().body(new MessageResponse(true, "Kulam added Successfully "));
		} else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Kulam not Successfully "));

	}

	@GetMapping("/util/getkulams")
	public ResponseEntity<List<KulamDTO>> getKulams() {
		return ResponseEntity.ok().body(familyService.getKulams());
	}

	@PostMapping("/util/addgothiram")
	public ResponseEntity<MessageResponse> addGothiram(@Valid @RequestBody GothiramDTO gothirams) {
		if (familyService.addGothirams(gothirams))
			return ResponseEntity.ok().body(new MessageResponse(true, "Gothiram added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Gothiram not Successfully "));

	}

	@GetMapping("/util/getgothirams")
	public ResponseEntity<List<GothiramDTO>> getGothirams() {
		return ResponseEntity.ok().body(familyService.getGothirams());
	}

	@PostMapping("/util/adddeity")
	public ResponseEntity<MessageResponse> addDeity(@Valid @RequestBody DeityDTO deity) {
		if (familyService.addDeitys(deity))
			return ResponseEntity.ok().body(new MessageResponse(true, "Deity added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deity not Successfully "));
	}

	@GetMapping("/util/getdeitys")
	public ResponseEntity<List<DeityDTO>> getDeitys() {
		return ResponseEntity.ok().body(familyService.getDeitys());
	}

	@PostMapping("/util/addcity")
	public ResponseEntity<MessageResponse> addCity(@Valid @RequestBody CityDTO city) {
		if (addressService.addCities(city))
			return ResponseEntity.ok().body(new MessageResponse(true, "Deity added Successfully "));
		else
			return ResponseEntity.badRequest().body(new MessageResponse(false, "Deity not Successfully "));

	}

	@GetMapping("/util/getcity")
	public ResponseEntity<List<CityDTO>> getCity() {
		return ResponseEntity.ok().body(addressService.getCities());
	}

	@PostMapping("/util/addjob")
	public MessageResponse addJob(@Valid @RequestBody JobDTO city) {
		return null;
	}

}
