package com.fullstackems.fullStackEmsBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fullstackems.fullStackEmsBackend.Repository.UserLoginRepository;
import com.fullstackems.fullStackEmsBackend.jwtpackage.Utility;
import com.fullstackems.fullStackEmsBackend.model.UserLogin;
import com.fullstackems.fullStackEmsBackend.security.AdminDetails;
import com.fullstackems.fullStackEmsBackend.security.AdminDetailsService;

@Service
public class AdminService {
	
	@Autowired
	UserLoginRepository userloginrepo;
	@Autowired
	AuthenticationManager authmanager;
	@Autowired
	Utility utils;
	@Autowired
	AdminDetailsService detailsService;
	
	public String Registration(UserLogin userlogin){
		try {
			BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
			String password = encoder.encode(userlogin.getPassword());
			userlogin.setPassword(password);
			userloginrepo.save(userlogin);
			return "Registered Successfully";
		}
		catch(Exception e) {
		return	e.toString();
		
		}
		
	}
	public String Login(UserLogin userLogin) {
		
		try {
			Authentication auth = authmanager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword())); 
			if(auth.isAuthenticated()) {
				AdminDetails adminDetails = new AdminDetails(userLogin);
				return utils.generateToken(adminDetails);
				
				
			}
			return "Invalid Credentials";
		}
		catch(Exception e) {
			return e.toString();
		}
	}
	
	public Boolean validtoken(String token) {
		try {
			String model= utils.getUsername(token);
			AdminDetails details= (AdminDetails) detailsService.loadUserByUsername(model);
			return utils.isTokenValidate(token, details);
		}
		catch(Exception e) {
			return false;
		}
	}
	
	

}