package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CASTE")
@Data
public class Caste {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CASTEID", nullable = false)
	private long id;
	@Column(name = "CASTENAME", unique = true, nullable = false)
	private String casteName;
}