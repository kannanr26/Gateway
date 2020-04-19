package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.CityLogical;


public class AddressUtil {
	private static List<CityDTO> cities;
	
	@Autowired
	
	private static CityLogical cityLogical;
	
	public static List<CityDTO> getCities() {
		if (AddressUtil.cities == null)  {
			AddressUtil.cities= new ArrayList<CityDTO>();
			AddressUtil.cities= cityLogical.findAll();
		}
		return AddressUtil.cities;
	}

	public static MessageResponse setCities(CityDTO cityToSave) {
		if (!getCities().contains(cityToSave)) {
			CityDTO city = cityLogical.save(cityToSave);
			AddressUtil.cities.add(city);
			return new MessageResponse(true ,"City"+UtilityConstant.SUCCESS);
		}
		return new MessageResponse(false ,"Kulam not added");
	}
	
	
}
