package com.community.gateway.logical;

import java.util.List;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.dto.DistrictDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface CityLogical {

	List<CityDTO> findAll() ;

	CityDTO findById(Long cityId)throws ResourceNotFoundException;
	//CityDTO findByName(String cityName)throws ResourceNotFoundException;
	List<CityDTO> findByDistrict(DistrictDTO districtId)throws ResourceNotFoundException;
	CityDTO save( CityDTO cityDTO);

	void deleteCity(Long cityId) throws ResourceNotFoundException;

	List<Long> getPincode();

	List<CityDTO> findByPincode(Long pincode);

	

}
