package com.community.gateway.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.community.gateway.model.e_num.EBloodGroup;
import com.community.gateway.model.e_num.EGender;

import lombok.Data;

@Entity
@Table(name = "PERSONALDETAILS")
@Data
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSONDETAILID", nullable = false)
	private long id;

	@Enumerated(EnumType.ORDINAL)
	private EGender gender;
	@Enumerated(EnumType.ORDINAL)
	private EBloodGroup bloodGroup;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	/*
	 * @Transient private int age; public int getAge() { return Period.between(dob,
	 * LocalDate.now()).getYears(); }
	 */
	 
}
