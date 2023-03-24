package com.fullstackems.fullStackEmsBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="usercredentials")
public class UserLogin {
	
	@Id
	private String username;
	@Column(name="password")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserLogin() {
		super();
	}
	

}
