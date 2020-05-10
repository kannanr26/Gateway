package com.community.gateway.jwt.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JWTResponse {
	private String accessToken;
	private String type = "GateWay";
	private String userName;
	private String roles;
	private String message;

	public JWTResponse(String accessToken, String userName, String roles, String msg) {
		this.accessToken = accessToken;
		this.userName = userName;
		this.roles = roles;
		this.message = msg;
	}

	public JWTResponse(String message) {
		this.message = message;
	}
}
