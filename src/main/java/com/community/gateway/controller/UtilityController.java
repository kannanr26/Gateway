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
import com.community.gateway.utility.AddressUtil;
import com.community.gateway.utility.FamilyService;

@RestController
@RequestMapping("/gws")
public class UtilityController {

    private final FamilyService familyService;

    @Autowired
    public UtilityController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @PostMapping("/util/addkulam")
    public MessageResponse addKulam(@Valid @RequestBody KulamDTO kulam) {
        return familyService.addKulams(kulam);
    }

    @GetMapping("/util/getkulams")
    public ResponseEntity<List<KulamDTO>> getKulams() {
        return ResponseEntity.ok().body(familyService.getKulams());
    }

    @PostMapping("/util/addgothiram")
    public MessageResponse addGothiram(@Valid @RequestBody GothiramDTO gothirams) {
        return familyService.addGothirams(gothirams);
    }

    @GetMapping("/util/getgothirams")
    public ResponseEntity<List<GothiramDTO>> getGothirams() {
        return ResponseEntity.ok().body(familyService.getGothirams());
    }

    @PostMapping("/util/adddeity")
    public MessageResponse addDeity(@Valid @RequestBody DeityDTO deity) {
        return familyService.addDeitys(deity);
    }

    @GetMapping("/util/getdeitys")
    public ResponseEntity<List<DeityDTO>> getDeitys() {
        return ResponseEntity.ok().body(familyService.getDeitys());
    }

    @PostMapping("/util/addcity")
    public MessageResponse addCity(@Valid @RequestBody CityDTO city) {
        return AddressUtil.setCities(city);
    }

    @PostMapping("/util/addjob")
    public MessageResponse addJob(@Valid @RequestBody JobDTO city) {
        return null;
    }


}
