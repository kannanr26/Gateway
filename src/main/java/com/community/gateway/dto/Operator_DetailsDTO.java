package com.community.gateway.dto;

import com.community.gateway.model.e_num.ERole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
public class Operator_DetailsDTO {
    private Date createdTimestamp;
    private OperatorDTO operator;
    private String operatorName;
    private ERole role;
}
