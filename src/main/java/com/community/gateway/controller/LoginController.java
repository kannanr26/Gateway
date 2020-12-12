package com.community.gateway.controller;

import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.jwt.response.JWTResponse;
import com.community.gateway.logical.OperatorLogical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;/*
import com.community.gateway.jwt.config.JwtUtils;
import com.community.gateway.jwt.config.UserDetailsImpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
*/
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/gw")
public class LoginController {
	@Autowired
	private  OperatorLogical loginL;
	/*private final AuthenticationManager authenticationManager;
	@Autowired
	private final JwtUtils jwtUtils;

	@Autowired
	public LoginController(OperatorLogical loginL, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
		this.loginL = loginL;
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;
	}*/

	@PostMapping("/authenticate")
	public ResponseEntity<JWTResponse> login(@Valid @RequestBody OperatorDTO operatorRequest) {

		OperatorDTO operator = null;
		String jwt = null;
		String role = null;
		try {
			operator = loginL.findByMobileNumber(operatorRequest.getMobileNumber());

			System.out.println(
					" Operator login :" + operatorRequest.getMobileNumber() + "  ::: " + operatorRequest.getPassword());
			if (operatorRequest.getPassword().equals(operator.getPassword())) {
				OperatorDTO finalOperator = operator;
				jwt=finalOperator.getOperatorName()+finalOperator.getMobileNumber();
			/*	GrantedAuthority grantedAuthority = (GrantedAuthority) () -> finalOperator.getRole().name();
				jwt=jwtUtils.generateJwtToken(finalOperator);
				/*Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(operator.getMobileNumber(),
								operator.getPassword(), Arrays.asList(grantedAuthority)));

				SecurityContextHolder.getContext().setAuthentication(authentication);

				jwt = jwtUtils.generateJwtToken(authentication);*/
			/*	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
						.collect(Collectors.toList());
				role = roles.get(0);*/
				// role=operator.getRole().name();
				
				
			}else {
				return ResponseEntity.badRequest().body(new JWTResponse("Password mismatch"));
			}
		} catch (com.community.gateway.exception.ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Login Error Operator Not found");
			return ResponseEntity.badRequest().body(new JWTResponse("Operator Not found, Login failed"));

		}

		return ResponseEntity.ok(new JWTResponse(jwt, operator.getOperatorName(), operator.getRole(), operator.getOperatorType(),"Success"));
	}

}
