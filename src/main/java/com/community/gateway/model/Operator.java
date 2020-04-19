/**
 *
 */
package com.community.gateway.model;

/**
 * @author deepikamalar
 * Role will be assigned only the person who  
 */

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "OPERATOR")
@Data
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPERATORID")
    private long id;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "MOBILENUMBER", unique = true, nullable = false)
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String mobileNumber;

    @OneToOne(mappedBy = "operator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Operator_Details operator_Details;

}
