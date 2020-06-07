package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.BusinessLogical;

@Service
public class BusinessUtilService {

	private static final List<BusinessDTO> business = new ArrayList<BusinessDTO>();

	private final BusinessLogical businessLocial;

	@Autowired
	public BusinessUtilService(BusinessLogical businessLocial) {
		this.businessLocial = businessLocial;
	}


	public List<BusinessDTO> getBusiness() {
		if (business.isEmpty()) {
			business.addAll(businessLocial.findAll());
		}
		return business;
	}

	public boolean addbusiness(BusinessDTO businessDTO) {
		if (getBusiness().stream().noneMatch(x -> x.getBusinessName().equalsIgnoreCase(businessDTO.getBusinessName()))) {
			BusinessDTO busines = businessLocial.save(businessDTO);
			business.add(busines);
			return true;
		}
		return false;

	}


	public boolean deleteBusiness(Long businessId) {
		// TODO Auto-generated method stub
		try {
			business.remove(businessLocial.findById(businessId));
			businessLocial.delete(businessId);
			 
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

	}


}