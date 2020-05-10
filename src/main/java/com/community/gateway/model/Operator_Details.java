package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "OPERATOR_DETAIL")
@Data
public class Operator_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPERATORDETAILID")
	private long id;
	/*
	 * @OneToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "operator_id", nullable = false) private Operator
	 * operator;
	 */
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn() private Address address;
	 */

}
