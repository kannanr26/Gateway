/**
 *
 */
package com.community.gateway.model;

import javax.persistence.Basic;
import javax.validation.constraints.Size;

/**
 * @author deepikamalar
 * Role will be assigned only the person who  
 */


import lombok.Data;

import javax.persistence.*;

import com.community.gateway.model.e_num.EOperator;
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

	@Column(name = "MOBILENUMBER", length = 10,unique = true, nullable = false)
	private long mobileNumber;

	@Column(name = "OPERATORNAME", nullable = false)
	private String operatorName;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIMESTAMP")
	private java.util.Date createdTimestamp;

	@Enumerated(EnumType.ORDINAL)
	private ERole role;

}
