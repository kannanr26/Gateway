package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.model.e_num.EOperator;
import com.community.gateway.model.e_num.ERole;

import lombok.Getter;

@Service
@Getter
public class EnumUtilService {
	//private  List<ERole> roles = new ArrayList<ERole>(ERole.values().length);
	private  List<EOperator> operatorType = new ArrayList<EOperator>(EOperator.values().length);
	
	@Autowired
	public EnumUtilService () {
		//roles=Arrays.asList(ERole.values());
		operatorType=Arrays.asList(EOperator.values());
	}
	

	
}


