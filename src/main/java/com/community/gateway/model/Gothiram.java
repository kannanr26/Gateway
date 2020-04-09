package com.community.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GOTHIRAM")
@Data
public class Gothiram {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GOTHIRAMID", nullable = false)
	private long id;
	@Column(name = "GOTHIRAMNAME", unique = true, nullable = false)
	private String gothiramName;
}