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
@Table(name = "OCCUPATION_DETAIL")
@Data
public class Occupation_Detail {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OCCUPATIONDETAILID")
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "PERSONID")
	private Person person;
	
	@Column(name="OCCUPATIONID")
	private int department;
	

}

	
