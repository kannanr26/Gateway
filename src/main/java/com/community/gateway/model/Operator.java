package com.community.gateway.model;

/**
 * @author deepikamalar
 * Role will be assigned only the person who  
 */

import lombok.Data;
import javax.persistence.*;

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

	@Column(name = "MOBILENUMBER", length = 10,unique = true, nullable = false)
	private long mobileNumber;

	@Column(name = "OPERATORNAME", nullable = false)
	private String operatorName;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIMESTAMP")
	private java.util.Date createdTimestamp;

	@OneToOne(fetch = FetchType.EAGER)
	private Role role;
	
	@OneToOne(fetch = FetchType.EAGER)
	private OperatorType operatorType;

}
