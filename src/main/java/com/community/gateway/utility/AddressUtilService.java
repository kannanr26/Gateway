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
	/**/

	private final CityLogical cityLogical;
	private final CountryLogical countryLogical;
	private final StateLogical stateLogical;
	private final DistrictLogical districtLogical;

	@Autowired
	public AddressUtilService(CityLogical cityLogical, CountryLogical countryLogical, StateLogical stateLogical,
			DistrictLogical districtLogical) {
		this.cityLogical = cityLogical;
		this.countryLogical = countryLogical;
		this.stateLogical = stateLogical;
		this.districtLogical = districtLogical;
	}

	public List<CityDTO> getCities(Long districtId) {
		try {
			return cityLogical.findByDistrictId(districtId);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<CityDTO>(1);

	}

	public boolean addCities(CityDTO cityDTO) {
		System.out.println("  CityDTO" + cityDTO.getCityName()+" cityDTO.getDistrictId()"+cityDTO.getDistrictId());
		if (getCities(cityDTO.getDistrictId()).stream()
				.noneMatch(x -> x.getCityName().equalsIgnoreCase(cityDTO.getCityName()))) {
			System.out.println(" inside  if city DTO");
			cityLogical.save(cityDTO);
			return true;
		}
		return false;
	}

	public boolean deleteCity(Long cityId) {
		try {
			cityLogical.deleteCity(cityId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<CountryDTO> getCountries() {
		return countryLogical.findAll();
	}

	public boolean addCountry(CountryDTO countryDTO) {
		if (getCountries().stream().noneMatch(x -> x.getCountryName().equalsIgnoreCase(countryDTO.getCountryName()))) {
			countryLogical.save(countryDTO);
			return true;
		}
		return false;
	}

	public boolean deleteCountry(Long countryId) {
		// TODO Auto-generated method stub
		try {
			countryLogical.delete(countryId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<StateDTO> getStates(Long countryId) {
		return stateLogical.findAllByCountryId(countryId);
	}

	public boolean addState(StateDTO stateDTO) {
		if (getStates(stateDTO.getCountryId()).stream()
				.noneMatch(x -> x.getStateName().equalsIgnoreCase(stateDTO.getStateName()))) {
			stateLogical.save(stateDTO);

			return true;
		}
		return false;
	}

	public boolean deleteState(Long stateId) {
		// TODO Auto-generated method stub
		try {
			stateLogical.delete(stateId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<DistrictDTO> getDistricts(Long stateId) {
		return districtLogical.findAllByStateId(stateId);
	}

	public boolean addDistrict(DistrictDTO districtDTO) {
		if (getDistricts(districtDTO.getStateId()).stream()
				.noneMatch(x -> x.getDistrictName().equalsIgnoreCase(districtDTO.getDistrictName()))) {
			districtLogical.save(districtDTO);
			return true;
		}
		return false;
	}

	public boolean deleteDistrict(Long districtId) {
		// TODO Auto-generated method stub
		try {
			districtLogical.delete(districtId);
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
