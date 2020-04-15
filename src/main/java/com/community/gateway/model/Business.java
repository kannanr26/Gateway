package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "BUSINESS")
@Data

public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BUSINESSID", nullable = false)
	private long id;
	@Column(name = "BUSINESSName", unique = true, nullable = false)
	private String businessName;

}