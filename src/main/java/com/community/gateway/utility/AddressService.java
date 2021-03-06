package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.CityLogical;

@Service
public class AddressService {
	private  final static List<CityDTO> cities = new ArrayList<CityDTO>();
	private final CityLogical cityLogical;
	
	@Autowired
	public AddressService (CityLogical cityLogical) {
		this.cityLogical = cityLogical;
	}
	
	public List<CityDTO> getCities() {
		if (cities.isEmpty()) {
			cities.addAll(this.cityLogical.findAll());
		}
		return cities;
	}

	public boolean addCities(CityDTO citiesDTO) {
		System.out.println("  gothiramDTO" + citiesDTO.getName());
		if (getCities().stream().noneMatch(x -> x.getName().equalsIgnoreCase(citiesDTO.getName()))) {
				System.out.println(" inside  if city DTO");
			CityDTO citySaved = this.cityLogical.save(citiesDTO);
			cities.add(citySaved);
			return true;
		}
		return false;
	}

	
}
