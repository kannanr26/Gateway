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
@Table(name = "Education_DETAIL")
@Data
public class Education_Detail {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EDUCATIONDETAILID")
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "PERSONID")
	private Person person;
	
	@Column(name="COURSEID")
	private int courses;
	
	@Column(name="EDUCATIONID")
	private int education;
}

	
