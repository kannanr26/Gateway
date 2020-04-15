package com.community.gateway.dto;

import com.community.gateway.model.e_num.ERelation;

//@Data
public class RelationShipsDTO {
	private long id;
	private long personId;
	private long  masterId;
	private ERelation relation;
	
	public RelationShipsDTO() {}
	
	public RelationShipsDTO(long personId,long masterId, ERelation relation) {
	this.personId=personId;
	this.masterId=masterId;
	this.relation=relation;
	
	}

	public long getId() {
		return id;
	}

	public long getPersonId() {
		return personId;
	}

	public long getMasterId() {
		return masterId;
	}

	public ERelation getRelation() {
		return relation;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public void setMasterId(long masterId) {
		this.masterId = masterId;
	}

	public void setRelation(ERelation relation) {
		this.relation = relation;
	}
}
