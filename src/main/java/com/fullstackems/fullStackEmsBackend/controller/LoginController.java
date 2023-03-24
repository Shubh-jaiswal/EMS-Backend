package com.fullstackems.fullStackEmsBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackems.fullStackEmsBackend.model.UserLogin;
import com.fullstackems.fullStackEmsBackend.service.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:3001")
public class LoginController {
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/register")
	public String Register(@RequestBody UserLogin userlogin) {
		return adminservice.Registration(userlogin);
		
	}
	
	@PostMapping("/login")
	public String Login(@RequestBody UserLogin userlogin) {
		return adminservice.Login(userlogin);
		
	}
	
	@GetMapping("/validation/{token}")
	public Boolean valid(@PathVariable String token) {
		return adminservice.validtoken(token);
	}
	
	

}
