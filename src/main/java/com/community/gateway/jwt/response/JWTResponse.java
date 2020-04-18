package com.community.gateway.jwt.response;

public class JWTResponse {
	private String token;
	private String type = "GateWay";
	private Long id;
	private String username;
	private long mobileNumber;
	private String roles;
	private String msg;

	public JWTResponse(String accessToken, Long id, String username, long mobileNumber, String roles, String msg) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.roles = roles;
		this.msg=msg;
	}

	public JWTResponse(String msg) {
		// TODO Auto-generated constructor stub
		this.msg=msg;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoles() {
		return roles;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
