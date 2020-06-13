package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COUNTRY")
@Data
public class Country {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRYID", nullable = false)
	private long id;
	@Column(name = "COUNTRYNAME", unique = true, nullable = false)
	private String countryName;
}