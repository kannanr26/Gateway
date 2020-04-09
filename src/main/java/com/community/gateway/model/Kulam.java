package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "KULAM")
@Data
public class Kulam {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KULAMID", nullable = false)
	private long id;
	@Column(name = "KULAMNAME", unique = true, nullable = false)
	private String kulamName;
}