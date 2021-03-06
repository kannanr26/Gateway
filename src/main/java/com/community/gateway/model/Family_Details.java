package com.community.gateway.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "FAMILYDETAILS")
@Data
public class Family_Details {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FAMILYDETAILSID", nullable = false)
	private long id;
	@Column(name = "FAMILYNAME", unique = true, nullable = false)
	private String familyName;
	
	@Column(name = "REGISTRATIONNUMBER", unique = true, nullable = false)
	private String registrationNumber;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(unique = true)
	 private Address address;
	
	 
	@OneToMany(mappedBy = "familyDetails", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Person> person;

	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn
	 private Kulam kulam;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn
	private Gothiram gothiram;
	
	
}