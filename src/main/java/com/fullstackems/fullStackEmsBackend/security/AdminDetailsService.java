package com.fullstackems.fullStackEmsBackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fullstackems.fullStackEmsBackend.Repository.UserLoginRepository;
import com.fullstackems.fullStackEmsBackend.model.UserLogin;

@Service
public class AdminDetailsService implements UserDetailsService {
	
	
    @Autowired
    UserLoginRepository userloginrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserLogin userlogin=userloginrepo.findById(username).get();
		return new AdminDetails(userlogin);
	}

}
