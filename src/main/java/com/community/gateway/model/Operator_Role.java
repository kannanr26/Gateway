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
@Table(name = "OPERATOR_ROLE")
@Data

public class Operator_Role {

	
	  @Id
	  
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 
	  @Column(name = "OPERATOR_ROLEID", nullable = false) private long id;
	  
	  @Column(name = "OPERATOR_ROLE", unique = true, nullable = false) private
	  String roleName;
	 

}
