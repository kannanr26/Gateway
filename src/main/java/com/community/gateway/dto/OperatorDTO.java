package com.community.gateway.dto;

import lombok.Data;

import java.util.Date;
@Data
public class OperatorDTO {
    private long id;
    private String operatorName;
    private String password;
    private long mobileNumber;
    private RoleDTO role;
    private OperatorTypeDTO operatorType;
    //private OperatorTypeDTO operatorType;
    private Date createdTimestamp;
    
}
