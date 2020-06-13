package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "MARITALSTATUS")
@Data
public class MaritalStatus {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MARITALSTATUSID", nullable = false)
	private long id;
	@Column(name = "MARITALSTATUSNAME", unique = true, nullable = false)
	private String maritalStatusName;
}