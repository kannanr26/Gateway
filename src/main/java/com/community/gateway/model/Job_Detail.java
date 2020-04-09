package com.community.gateway.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "JOB_DETAIL")
@Data
public class Job_Detail {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JOBDETAILID")
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "PERSONID")
	private Person person;
	
	@Column(name="DEPARTMENTID")
	private int department;
	
	@Column(name="JOBID")
	private int job;
	
	@Column(name="JOBTITLEID")
	private int jobTitle;
	
	@Column(name="EXPERIENCE")
	private int yearsOfExperience;
}

	
