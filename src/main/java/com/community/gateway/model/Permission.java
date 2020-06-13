package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PERMISSION")
@Data
public class Permission {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERMISSIONID", nullable = false)
	private long id;
	@Column(name = "PERMISSIONNAME", unique = true, nullable = false)
	private String permissionName;
}