/**
 *
 */
package com.community.gateway.model;

import javax.persistence.Basic;

/**
 * @author deepikamalar
 * Role will be assigned only the person who  
 */


import lombok.Data;

import javax.persistence.*;

import javax.validation.constraints.Pattern;

import com.community.gateway.model.e_num.ERole;

@Entity
@Table(name = "OPERATOR")
@Data
public class Operator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "OPERATORID")
	private long id;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "MOBILENUMBER", unique = true, nullable = false)
	@Pattern(regexp = "(^$|[0-9]{10})")
	private long mobileNumber;

	@Column(name = "OPERATORNAME", nullable = false)
	private String operatorName;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIMESTAMP")
	private java.util.Date createdTimestamp;

	@Enumerated(EnumType.ORDINAL)
	private ERole role;

	public long getId() {
		return id;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public java.util.Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public ERole getRole() {
		return role;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public void setCreatedTimestamp(java.util.Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public void setId(long id) {
		this.id = id;
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


}
