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
@Table(name = "CITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"DISTRICTID", "CITYNAME"})})
@Data
public class City {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITYID", nullable = false)
	private long id;
	@Column(name = "DISTRICTID", nullable = false)
	private long districtId;
	@Column(name = "CITYNAME", nullable = false)
	private String cityName;
}