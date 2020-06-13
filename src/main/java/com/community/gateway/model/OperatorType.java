package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "OperatorType")
@Data
public class OperatorType {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OPERATORTYPEID", nullable = false)
	private long id;
	@Column(name = "OPERATORTYPENAME", unique = true, nullable = false)
	private String operatorTypeName;
}