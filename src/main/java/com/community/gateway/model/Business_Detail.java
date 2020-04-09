package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "BUSINESS_DETAIL")
@Data
public class Business_Detail {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BUSINESSDETAILID")
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "PERSONID")
	private Person person;
	
	@Column(name="BUSINESSTID")
	private int business;
	
	/*
	 * @Column(name="JOBID") private int job;
	 * 
	 * @Column(name="JOBTITLEID") private int jobTitle;
	 */
	
	@Column(name="EXPERIENCE")
	private int yearsOfExperience;
}

	
