package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "STATE", uniqueConstraints = {@UniqueConstraint(columnNames = {"COUNTRYID","STATENAME"})})
@Data
public class State {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATEID", nullable = false)
	private long id;
	@Column(name = "COUNTRYID", nullable = false)
	private long countryId;
	@Column(name = "STATENAME",unique =true,  nullable = false)
	private String stateName;
}