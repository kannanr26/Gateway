package com.community.gateway.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.gateway.dto.OperatorDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.OperatorLogical;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	OperatorLogical operatorLogical;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
		OperatorDTO user = null;
		try {
			user = operatorLogical.findByMobile(Integer.parseInt(mobileNumber));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			 new UsernameNotFoundException("User Not Found with  mobileNumber : " + mobileNumber);
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			 new UsernameNotFoundException("User Not Found with  mobileNumber : " + mobileNumber);
			e.printStackTrace();
		}
			
		return UserDetailsImpl.build(user);
	}

}
