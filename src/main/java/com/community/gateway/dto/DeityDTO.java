package com.community.gateway.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class DeityDTO {

    private long id;
    private String deityName;
    private String cityName;

}