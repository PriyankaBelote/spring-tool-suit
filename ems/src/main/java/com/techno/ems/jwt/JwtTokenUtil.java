package com.techno.ems.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.techno.ems.entity.Employee;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
    
    @Value("${app.jwt.secret}")
    private String secretKey;
     
    public String generateAccessToken(Employee employee) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", employee.getEmpEmailId(), employee.getEmpPassword()))
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
                 
    }
}
