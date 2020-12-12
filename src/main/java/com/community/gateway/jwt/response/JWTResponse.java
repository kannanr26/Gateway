package com.community.gateway.jwt.response;

import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.dto.OperatorTypeDTO;
import com.community.gateway.dto.RoleDTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class JWTResponse {
	private String accessToken;
	private String type = "GateWay";
	private String userName;
	private RoleDTO roledto;
	private OperatorTypeDTO operatorTypedto;
	private String message;

	public JWTResponse(String accessToken, String userName,  RoleDTO roledto, OperatorTypeDTO operatorTypedto,String msg) {
		this.accessToken = accessToken;
		this.userName = userName;
		this.roledto = roledto;
		this.operatorTypedto=operatorTypedto;
		this.message = msg;
	}

	public JWTResponse(String message) {
		this.message = message;
	}
}
