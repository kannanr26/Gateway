package com.community.gateway.dto;

import com.community.gateway.model.e_num.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@Data
public class OperatorDTO {
	private long id;
	private String operatorName;
	@JsonIgnore
	private String password;
	private long mobileNumber;

	private ERole role;
	private java.util.Date createdTimestamp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	private Operator_DetailsDTO operator_Details;

	public Operator_DetailsDTO getOperator_Details() {
		return operator_Details;
	}

	public void setOperator_Details(Operator_DetailsDTO operator_Details) {
		this.operator_Details = operator_Details;
	}

	public java.util.Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(java.util.Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

}
