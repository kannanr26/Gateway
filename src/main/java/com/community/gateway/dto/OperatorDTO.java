package com.community.gateway.dto;

import com.community.gateway.model.e_num.EOperator;
import com.community.gateway.model.e_num.ERole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@Setter
@Getter
@EqualsAndHashCode
public class OperatorDTO {
    private long id;
    private String operatorName;
    private String password;
    private long mobileNumber;
    private ERole role;
    private EOperator[] operatorType;
    private Date createdTimestamp;
    
}
