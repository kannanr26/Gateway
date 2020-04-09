package com.community.gateway.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.community.gateway.model.e_num.ERole;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OPERATOR_DETAIL")
@Data

public class Operator_Details {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "OPERATORDETAILID")
	private long id;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIMESTAMP")
	private java.util.Date createdTimestamp;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Operator operator;

	@Column(name = "OPERATORNAME", nullable = false)
	private String operatorName;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn() private Address address;
	 */

	@Enumerated(EnumType.ORDINAL)
	private ERole role;
}
