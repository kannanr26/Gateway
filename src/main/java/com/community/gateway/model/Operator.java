/**
 * 
 */
package com.community.gateway.model;

/**
 * @author deepikamalar
 * Role will be assigned only the person who  
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "OPERATOR")
//@Data
public class Operator {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	@Column(name = "OPERATORID")
	private long id;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "MOBILENUMBER", unique = true, nullable = false)
	@Pattern(regexp = "(^$|[0-9]{10})")
	private long mobileNumber;
	
	@OneToOne(mappedBy = "operator")
	private Operator_Details operator_Details;

	/*
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "OPERATOR_ROLEID", referencedColumnName = "Role_ID",
	 * nullable = false) private Operator_Role operatorRole;
	 */
	/*
	 * @OneToMany(mappedBy = "", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 * 
	 * @Column(name = "OPERATOR_LOGINDETAILS") private List<Operator_LoginDetails>
	 * operator_LoginDetails;
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * public String getOperatorName() { return operatorName; }
	 * 
	 * public void setOperatorName(String operatorName) { this.operatorName =
	 * operatorName; }
	 */

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

	public Operator_Details getOperator_Details() {
		return operator_Details;
	}

	public void setOperator_Details(Operator_Details operator_Details) {
		this.operator_Details = operator_Details;
	}

}
