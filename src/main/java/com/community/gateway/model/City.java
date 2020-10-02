package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
//@Table(name = "CITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"DISTRICTID", "CITYNAME"})})
@Table(name = "CITY")
@Data
public class City {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITYID", nullable = false)
	private long id;
	@Column(name = "CITYNAME", nullable = false)
	private String cityName;
	
	@OneToOne(fetch = FetchType.EAGER)
	private District district;
	
	@OneToOne(fetch = FetchType.EAGER)
	private State state;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Country country;
	
	@Column(name = "PINCODE", nullable = false)
	private long pincode;
	
}