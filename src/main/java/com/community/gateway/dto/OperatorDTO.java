package com.community.gateway.dto;

import com.community.gateway.model.e_num.ERole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Setter
@Getter
@EqualsAndHashCode
public class OperatorDTO {
    private long id;
    private String operatorName;
    private String password;
    private long mobileNumber;
    private ERole role;
    private Date createdTimestamp;
    //private Operator_DetailsDTO operator_Details;
	public long getId() {
		return id;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public String getPassword() {
		return password;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public ERole getRole() {
		return role;
	}
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setRole(ERole role) {
		this.role = role;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

}
