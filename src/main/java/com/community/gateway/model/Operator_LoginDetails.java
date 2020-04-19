package com.community.gateway.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "OPERATOR_LOGIN_DETAIL")
@Data
@Getter
@Setter
public class Operator_LoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OPERATORLOGINDETAILID")
	private long id;
@Basic
@Temporal(TemporalType.TIMESTAMP)
@Column(name="LOGIN_TIMESTAMP")
private java.util.Date utilTimestamp;
	
	/*
	 * @ManyToOne private Operator operator;
	 */


}
