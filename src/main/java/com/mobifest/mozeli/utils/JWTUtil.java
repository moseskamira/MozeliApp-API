package com.mobifest.mozeli.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtil {
	private static String SECRET_KEY = "sAuTHY1@Y";
	
	public String extractUsername(String myToken) {
        return extractClaim(myToken, Claims::getSubject);
    }

    public Date extractExpiration(String myToken) {
        return extractClaim(myToken, Claims::getExpiration);
    }

    public <T> T extractClaim(String myToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(myToken);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String myToken) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(myToken).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        Date tokenIssuedDate = new Date(System.currentTimeMillis());
        Date tokenExpiryDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
        String genToken = Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
        		.setIssuedAt(tokenIssuedDate)
                .setExpiration(tokenExpiryDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        return genToken;
    }

    public Boolean validateToken(String myToken, UserDetails userDetails) {
        final String username = extractUsername(myToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(myToken));
    }
	
	

}
