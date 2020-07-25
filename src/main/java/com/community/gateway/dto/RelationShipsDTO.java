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
}
