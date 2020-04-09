package com.community.gateway.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address implements Serializable {
	// person who is associated with the address

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESSID")
	private long id;

	@Column(name = "houseNumber", nullable = false)
	private int houseNumber;

	@Column(name = "streetName", nullable = false)
	private String streetName;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "zipCode", nullable = false)
	private String zipCode;

	@OneToOne(mappedBy = "address")
	private Family_Details familyDetails;

	@OneToOne(mappedBy = "personalAddress")
	private Person person;

}