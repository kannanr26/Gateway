package com.community.gateway.dto;

import lombok.Data;

@Data
public class CityDTO {

	private long id;
	private CountryDTO country;
	private DistrictDTO district;
	private StateDTO state;
	private long pincode;
	private String cityName;
}