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
@Table(name = "DISTRICT", uniqueConstraints = {@UniqueConstraint(columnNames = {"STATEID","DISTRICTNAME"})})
@Data
public class District {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DISTRICTID", nullable = false)
	private long id;
	@Column(name = "STATEID", nullable = false)
	private long stateId;
	@Column(name = "DISTRICTNAME",unique=true, nullable = false)
	private String districtName;
}