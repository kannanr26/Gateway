package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CITY")
@Data
public class City {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITYID", nullable = false)
	private long id;
	@Column(name = "CITYNAME", unique = true, nullable = false)
	private String cityName;
}