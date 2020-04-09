package com.community.gateway.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PERSON")
@Data

public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSONID", nullable = false)
	private long id;

	@Column(name = "PERSONNAME", nullable = false)
	private String personName;

	/*
	 * @Enumerated(EnumType.ORDINAL) private EGender gender;
	 */

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Education_Detail> educationDetails;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Job_Detail> jobDetail;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<RelationShips> relationShip;

	@ManyToOne
	@JoinColumn(name="familyDetails")
	private Family_Details familyDetails;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "PERSONALADDRESS",unique = true)
	 private Address personalAddress;
	
}