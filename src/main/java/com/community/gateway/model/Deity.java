package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DEITY")
@Data
public class Deity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEITYID", nullable = false)
	private long id;
	@Column(name = "DEITYNAME", unique = true, nullable = false)
	private String deityName;
	@Column(name = "locatation", nullable = false)
	private String cityName;
	
}