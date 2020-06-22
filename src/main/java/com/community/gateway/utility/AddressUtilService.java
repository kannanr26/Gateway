package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.CountryDTO;
import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.StateDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.CityLogical;
import com.community.gateway.logical.CountryLogical;
import com.community.gateway.logical.DistrictLogical;
import com.community.gateway.logical.StateLogical;
import com.community.gateway.logical.Utility;

@Service
public class AddressUtilService {
	/**/
	private static final List<CountryDTO> countrys = new ArrayList<CountryDTO>();

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

	public ResponseEntity<MessageResponse> addCities(CityDTO cityDTO) {
		if (getCities(cityDTO.getDistrictId()).stream()
				.noneMatch(x -> x.getCityName().equalsIgnoreCase(cityDTO.getCityName()))) {
			CityDTO cityDtoSaved = cityLogical.save(cityDTO);
			if (cityDTO.getId() == 0)
				return ResponseEntity.ok().body(new MessageResponse(cityDtoSaved, true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));

		}
		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));

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
		if (countrys.isEmpty())
			countrys.addAll(countryLogical.findAll());
		return countrys;
	}

	public ResponseEntity<MessageResponse> addCountry(CountryDTO countryDTO) {
		try {
		if (getCountries().stream().noneMatch(x -> x.getCountryName().equalsIgnoreCase(countryDTO.getCountryName()))) {
			 CountryDTO countryDTOSaved =countryLogical.save(countryDTO);
			 refreshCountry();
			 if(countryDTO.getId()==0) 
					return ResponseEntity.ok().body(new MessageResponse(countryDTOSaved,true, UtilityConstant.SUCCESS));
			else
						return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
						
			 }
		}catch (Exception e) {
			
		}
		return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));

	}

	private void refreshCountry() {
		// TODO Auto-generated method stub
		countrys.clear();
		countrys.addAll(getCountries());

	}

	public boolean deleteCountry(Long countryId) {
		try {
			countryLogical.delete(countryId);
			refreshCountry();
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

	public ResponseEntity<MessageResponse> addState(StateDTO stateDTO) {
		if (getStates(stateDTO.getCountryId()).stream()
				.noneMatch(x -> x.getStateName().equalsIgnoreCase(stateDTO.getStateName()))) {
			StateDTO stateSaved=stateLogical.save(stateDTO);
			if(stateDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(stateSaved,true,UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse(true,UtilityConstant.UPDATED_SUCCESS));
		}
		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));

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

	public ResponseEntity<MessageResponse> addDistrict(DistrictDTO districtDTO) {
		if (getDistricts(districtDTO.getStateId()).stream()
				.noneMatch(x -> x.getDistrictName().equalsIgnoreCase(districtDTO.getDistrictName()))) {
			DistrictDTO districtSaved=districtLogical.save(districtDTO);
			if(districtDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(districtSaved,true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS));
		}
		
		return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));

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
