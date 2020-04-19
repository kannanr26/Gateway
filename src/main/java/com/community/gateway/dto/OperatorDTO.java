package com.community.gateway.dto;

import com.community.gateway.model.e_num.ERole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Setter
@Getter
@EqualsAndHashCode
public class OperatorDTO {
    private long id;
    private String operatorName;
    private String password;
    private String mobileNumber;
    private ERole role;
    private Date createdTimestamp;
    private Operator_DetailsDTO operator_Details;

}
