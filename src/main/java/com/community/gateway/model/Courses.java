package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "COURSES")
@Data
public class Courses {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSEID", nullable = false)
	private long id;
	@Column(name = "COURSENAME", unique = true, nullable = false)
	private String courseName;
}

	
