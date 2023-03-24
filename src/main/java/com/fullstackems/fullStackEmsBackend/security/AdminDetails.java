package com.fullstackems.fullStackEmsBackend.security;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fullstackems.fullStackEmsBackend.model.UserLogin;

@Component
public class AdminDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1900801791033032291L;
	@Autowired
	UserLogin userlogin;
	
	
	
	
	public AdminDetails(UserLogin userlogin) {
		super();
		this.userlogin = userlogin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("Login"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userlogin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userlogin.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
