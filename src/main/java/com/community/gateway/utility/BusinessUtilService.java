package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.BusinessDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
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

	public ResponseEntity<MessageResponse> addbusiness(BusinessDTO businessDTO) {
		
		try {
		if (getBusiness().stream().noneMatch(x -> x.getBusinessName().equalsIgnoreCase(businessDTO.getBusinessName()))) {
			BusinessDTO businessSaved = businessLocial.save(businessDTO);
			refreshBusiness();
					
		if(businessDTO.getId()==0)
			return ResponseEntity.ok().body(new MessageResponse(businessSaved,true, UtilityConstant.SUCCESS));
		else
			return ResponseEntity.ok().body(new MessageResponse(true,UtilityConstant.UPDATED_SUCCESS));
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));

	}


	private void refreshBusiness() {
		// TODO Auto-generated method stub
		business.clear();
		business.addAll(getBusiness());
	}


	public boolean deleteBusiness(Long businessId) {
		// TODO Auto-generated method stub
		try {
			businessLocial.delete(businessId);
			refreshBusiness(); 
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

	}


}