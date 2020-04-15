package com.community.gateway.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.utility.FamilyUtil;

@RestController
@RequestMapping("/gateway")
public class UtilityController {

	/*
	 * @Autowired FamilyUtil familyUtil;
	 */
	@PostMapping("/util/addKulam")
	public MessageResponse addKulam(@Valid @RequestBody KulamDTO kulam) {
		return FamilyUtil.addKulams(kulam);
	}
	@PostMapping("/util/addGothiram")
	public MessageResponse addGothiram  (@Valid @RequestBody GothiramDTO gothirams) {
		return FamilyUtil.addGothirams(gothirams);
	}

	@PostMapping("/util/addDeity")
	public MessageResponse addDeity(@Valid @RequestBody DeityDTO deity) {
		return FamilyUtil.addDeitys(deity);
	}
	
}
