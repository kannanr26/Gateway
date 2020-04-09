package com.community.gateway.logical;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CityDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.CityMapper;
import com.community.gateway.service.CityService;

@Service
public class CityLogicalImpl implements CityLogical {

	@Autowired
	CityService cityService;

	@Autowired
	CityMapper cityMapper;

	private List<CityDTO> findAllService() { // TODO Auto-generated method stub
		return cityMapper.toCityDTOs(cityService.findAll());
	}

	@Override
	public CityDTO findById(Long cityId) throws ResourceNotFoundException {
		return cityMapper.toCityDTO(cityService.findById(cityId));
	}

	private CityDTO save(@Valid CityDTO cityDto) {
		// TODO Auto-generated method stub
		return cityMapper.toCityDTO(cityService.save(cityMapper.toCity(cityDto)));

	}

	private void delete(Long cityId) throws ResourceNotFoundException {
		cityService.delete(cityId);

	}

	private static Map<Integer, String> city;

	@Override
	public Map<Integer, String> findAll() {
		if (city == null) {
			List<CityDTO> cityDto = findAllService();
			city = cityDto.stream().collect(Collectors.toMap(CityDTO::getId, CityDTO::getName));
			return city;
		}
		return city;

	}

	public void addCity(CityDTO citydto) {
		if (city.containsValue(citydto.getName()))
			return;
		else {
			CityDTO cityDtoSaved = save(citydto);
			city.put(cityDtoSaved.getId(), cityDtoSaved.getName());
		}
	}

	@Override
	public void deleteCity(Long cityId) throws ResourceNotFoundException {
		if (city.containsKey(cityId)) {
			cityService.delete(cityId);
			city.remove(cityId);
		} else {
			CityDTO cityDtoSaved = findById(cityId);
			// city.put(cityDtoSaved.getId(), cityDtoSaved.getName());.
			if (cityDtoSaved != null) {
				cityService.delete(cityId);

			}
		}
	}

//	@Override
//	public CityDTO findByName(String cityName) throws ResourceNotFoundException {
//		if (city.containsValue(cityName)) {
//		return city.
//	}

}
