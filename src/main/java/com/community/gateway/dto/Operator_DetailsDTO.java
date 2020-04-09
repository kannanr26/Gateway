package com.community.gateway.dto;

import com.community.gateway.model.e_num.ERole;

import lombok.Data;

@Data
public class Operator_DetailsDTO {


public java.util.Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(java.util.Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public OperatorDTO getOperator() {
		return operator;
	}

	public void setOperator(OperatorDTO operator) {
		this.operator = operator;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

private java.util.Date createdTimestamp;
private OperatorDTO operator;
private String operatorName;

private ERole role;
}
