package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EDUCATION")
@Data

public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EDUCATION_ID", nullable = false)
	private long id;
	@Column(name = "EDUCATIONNAME", unique = true, nullable = false)
	private String educationName;
}
