package com.community.gateway.dto;

import com.community.gateway.model.e_num.ERelation;

import lombok.Data;

@Data
public class RelationShipsDTO {
	private long id;
	private PersonDTO personDTO;
	private int masterId;
	private ERelation relation;
}
