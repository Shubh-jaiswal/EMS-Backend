package com.fullstackems.fullStackEmsBackend.jwtpackage;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fullstackems.fullStackEmsBackend.security.AdminDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class Utility implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long expireTime=24*60*60*1000;
    private final String Secret_key="5u8x/A?D(G+KbPeShVmYq3t6v9y$B&E)H@McQfTjWnZr4u7x!z%C*F-JaNdRgUkX";

    public String generateToken(AdminDetails admindetails) {
         Map<String,Object> claim=new HashMap<>();
        
        return Jwts.builder().setClaims(claim)
                .setSubject(admindetails
                        .getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ expireTime))
                .signWith(SignatureAlgorithm.HS512, Secret_key).compact();
            
    }
    
    private Claims getAllclaims(String token) {
        
        return Jwts.parser().setSigningKey(Secret_key).parseClaimsJws(token).getBody();
    }
    
    public String getUsername(String token) {
        
        return getAllclaims(token).getSubject();
    }
    
    public Boolean isTokenValidate(String token , AdminDetails empdetail) {
        Boolean token_validation=getAllclaims(token).getExpiration().before(new Date());
        String username=getUsername(token);
        return (username.equals(empdetail.getUsername()) && !token_validation);
    }
    
}