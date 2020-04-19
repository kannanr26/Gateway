package com.community.gateway.dto;

import lombok.Data;


public class JobDTO {
	private long id;
	private String roleName;
	public long getId() {
		return id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}