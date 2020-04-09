package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "JOB")
@Data

public class JobTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JOBID", nullable = false)
	private long id;
	@Column(name = "JOBName", unique = true, nullable = false)
	private String roleName;

}