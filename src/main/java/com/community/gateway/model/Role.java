/**
 * 
 */
package com.community.gateway.model;

/**
 * @author deepikamalar
 * Role will be assigned only the person who  
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ROLE")
@Data
public class Role {

	
	  @Id
	  
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  
	 @Column(name = "ROLEID", nullable = false) private long id;
	/* * 
	 * @Column(name = "ROLENAME", unique = true, nullable = false) private String
	 * roleName;
	 */
}
