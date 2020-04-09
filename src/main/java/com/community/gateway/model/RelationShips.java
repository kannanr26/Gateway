package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.community.gateway.model.e_num.ERelation;

import lombok.Data;
@Entity
@Table(name = "RELATIONSHIP")
@Data
public class RelationShips {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RELATIONSHIPID")
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name = "PERSONID")
	private Person person;
	
	@Column(name="MASTERID")
	private int masterId;
	
	@Enumerated(EnumType.ORDINAL)
	private ERelation relation;
	
}
