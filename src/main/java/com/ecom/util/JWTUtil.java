package com.ecom.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JWTUtil {
	
	private String secret = "Alpha";

	//1 ,4
    public String extractUsername(String token) {
    	  // System.out.println("extractUsername block---->"+token);
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
    	   //System.out.println("extractExpiration block---->"+token);
        return extractClaim(token, Claims::getExpiration);
    }

    //3
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
       // System.out.println("extractClaim block---->"+claims);
        return claimsResolver.apply(claims);
    }
    //2
    private Claims extractAllClaims(String token) {
    	   //System.out.println("extractAllClaims block---->"+token);
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
    	   //System.out.println("isTokenExpired block---->"+token);
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", username.getAuthorities());
        return createToken(claims, username.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
    	
    		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        //System.out.println("validateToken block");
        return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
