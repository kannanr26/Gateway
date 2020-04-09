package com.community.gateway.logical;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CityDTO;

@Service
/* @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) */
public class Utility {

	@Autowired
	private  CityLogical cityL;

}
