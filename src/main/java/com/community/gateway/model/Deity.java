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
@Table(name = "DEITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"DEITYNAME","DISTRICTID", "CITYID"})})
@Data
public class Deity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEITYID", nullable = false)
	private long id;
	@Column(name = "DEITYNAME", unique = true, nullable = false)
	private String deityName;
	@Column(name = "CITYID", nullable = false)
	private long cityId;
	
}