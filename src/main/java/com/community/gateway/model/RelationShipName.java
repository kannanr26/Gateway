package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RELATIONSHIPNAME")
@Data
public class RelationShipName {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RELATIONSHIPNAMEID", nullable = false)
	private long id;
	@Column(name = "RELATIONSHIPNAME", unique = true, nullable = false)
	private String relationshipName;
}