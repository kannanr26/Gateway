package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BLOODGROUP")
@Data
public class BloodGroup {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BLOODGROUPID", nullable = false)
	private long id;
	@Column(name = "BLOODGROUPNAME", unique = true, nullable = false)
	private String bloodGroupName;
}