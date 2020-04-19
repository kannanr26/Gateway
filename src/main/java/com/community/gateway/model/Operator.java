/**
 * 
 */
package com.community.gateway.model;

import javax.persistence.Basic;

/**
 * @author deepikamalar
 * Role will be assigned only the person who  
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import com.community.gateway.model.e_num.ERole;

@Entity
@Table(name = "OPERATOR")
//@Data
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

	/*
	 * @OneToOne(mappedBy = "operator", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL) private Operator_Details operator_Details;
	 */
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
	/*
	 * public List<Operator_LoginDetails> getOperator_LoginDetails() { return
	 * operator_LoginDetails; }
	 * 
	 * public void setOperator_LoginDetails(List<Operator_LoginDetails>
	 * operator_LoginDetails) { this.operator_LoginDetails = operator_LoginDetails;
	 * }
	 */
/*
	public Operator_Details getOperator_Details() {
		return operator_Details;
	}

	public void setOperator_Details(Operator_Details operator_Details) {
		this.operator_Details = operator_Details;
	}
*/
}
