package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENTID", nullable = false)
	private long id;
	@Column(name = "DEPARTMENTNAME", unique = true, nullable = false)
	private String courseName;
}

	
