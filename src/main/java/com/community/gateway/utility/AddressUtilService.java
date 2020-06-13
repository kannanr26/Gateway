package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.CountryDTO;
import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.dto.StateDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.CityLogical;
import com.community.gateway.logical.CountryLogical;
import com.community.gateway.logical.DistrictLogical;
import com.community.gateway.logical.StateLogical;

@Service
public class AddressUtilService {
	private  final static List<CityDTO> cities = new ArrayList<CityDTO>();
	private static final List<CountryDTO> countries = new ArrayList<CountryDTO>();
	private static final List<StateDTO> states = new ArrayList<StateDTO>();
	private static final List<DistrictDTO> districts = new ArrayList<DistrictDTO>();

	
	private final CityLogical cityLogical;
	private final CountryLogical countryLogical;
	private final StateLogical stateLogical;
	private final DistrictLogical districtLogical;

	@Autowired
	public AddressUtilService (CityLogical cityLogical,CountryLogical countryLogical, StateLogical stateLogical,DistrictLogical districtLogical) {
		this.cityLogical = cityLogical;
		this.countryLogical=countryLogical;
		this.stateLogical=stateLogical;
		this.districtLogical=districtLogical;
	}
	
	public List<CityDTO> getCities() {
		if (cities.isEmpty()) {
			cities.addAll(this.cityLogical.findAll());
		}
		return cities;
	}

	public boolean addCities(CityDTO citiesDTO) {
		System.out.println("  gothiramDTO" + citiesDTO.getCityName());
		if (getCities().stream().noneMatch(x -> x.getCityName().equalsIgnoreCase(citiesDTO.getCityName()))) {
				System.out.println(" inside  if city DTO");
			CityDTO citySaved = this.cityLogical.save(citiesDTO);
			cities.add(citySaved);
			return true;
		}
		return false;
	}

	public boolean deleteCity(Long cityId) {
		 try {
			 cities.remove(cityLogical.findById(cityId));
			 cityLogical.deleteCity(cityId);
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
	public List<CountryDTO> getCountries() {
		if (countries.isEmpty()) {
			countries.addAll(countryLogical.findAll());
		}
		return countries;
	}

	public boolean addCountry(CountryDTO countryDTO) {
		if (getCountries().stream()
				.noneMatch(x -> x.getCountryName().equalsIgnoreCase(countryDTO.getCountryName()))) { 
			CountryDTO country = countryLogical.save(countryDTO);
			countries.add(country);
			return true;
		}
		return false;
	}

	public boolean deleteCountry(Long countryId) {
		// TODO Auto-generated method stub
		try {
			countries.remove(countryLogical.findById(countryId));
			countryLogical.delete(countryId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	public List<StateDTO> getStates() {
		if (states.isEmpty()) {
			states.addAll(stateLogical.findAll());
		}
		return states;
	}

	public boolean addState(StateDTO stateDTO) {
		if (getStates().stream()
				.noneMatch(x -> x.getStateName().equalsIgnoreCase(stateDTO.getStateName()))) { 
			StateDTO state = stateLogical.save(stateDTO);
			states.add(state);
			return true;
		}
		return false;
	}

	public boolean deleteState(Long stateId) {
		// TODO Auto-generated method stub
		try {
			states.remove(stateLogical.findById(stateId));
			stateLogical.delete(stateId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<DistrictDTO> getDistricts() {
		if (districts.isEmpty()) {
			districts.addAll(districtLogical.findAll());
		}
		return districts;
	}

	public boolean addDistrict(DistrictDTO districtDTO) {
		if (getDistricts().stream().noneMatch(x -> x.getDistrictName().equalsIgnoreCase(districtDTO.getDistrictName())  )){
		//		&& x.getStateId().equals(districtDTO.getStateId()) )) { 
			
			
			
			DistrictDTO district = districtLogical.save(districtDTO);
			districts.add(district);
			return true;
		}
		return false;
	}

	public boolean deleteDistrict(Long districtId) {
		// TODO Auto-generated method stub
		try {
			districts.remove(districtLogical.findById(districtId));
			districtLogical.delete(districtId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
