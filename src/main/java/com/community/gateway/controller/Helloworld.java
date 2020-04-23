package com.community.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

	@GetMapping("/helloworld")
	public ResponseEntity<String> helloworld() {
		String strMsg= "HELLO WORLD";
		return ResponseEntity.ok().body(strMsg);
	}
}
