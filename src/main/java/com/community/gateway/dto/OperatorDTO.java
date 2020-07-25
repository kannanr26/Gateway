package com.community.gateway.dto;

import com.community.gateway.model.Role;
import com.community.gateway.model.e_num.EOperator;
import com.community.gateway.model.e_num.ERole;

import lombok.Data;

import java.util.Date;
@Data
public class OperatorDTO {
    private long id;
    private String operatorName;
    private String password;
    private long mobileNumber;
    private ERole role;
    private EOperator[] operatorType;
    //private OperatorTypeDTO operatorType;
    private Date createdTimestamp;
    
}
