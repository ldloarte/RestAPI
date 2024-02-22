package com.demo.apirestful.RestAPI.jwt;

import com.demo.apirestful.RestAPI.access.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.Entity;
import lombok.Builder;
import org.springdoc.webmvc.core.fn.SpringdocRouteBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;

@Builder
@Service
public class JWTService {

    private static final String SECRET_KEY = "5020d23b6fSe148705d48a269ea7c5d2a65eccd6cae5877041d3957788174b42";

    public String getUserName(String token){
        return getClaim(token, Claims::getSubject);
    }

    private <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getToken(UserDetails userDetails){
        return getToken(new HashMap<>(), userDetails);
    }
    private String getToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts.builder().setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey() {
        return null;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    private boolean isTokenExpired(String token) { return getExpiration(token).before(new Date());}

    private Date getExpiration(String token) { return getClaim(token, Claims::getExpiration);

    }
}

