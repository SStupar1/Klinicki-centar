package com.ftn.isa.service.impl;

import com.ftn.isa.domain.User;
import com.ftn.isa.service.ITokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService implements ITokenService {

    @Value("${security.secret}")
    private String secret;

    @Value("${security.exp}")
    private Long expiration;

    @Override
    public String getUsernameFromToken(String token){
        String username;
        try{
            Claims claims = this.getClaimsFromToken(token);
            username = claims.getSubject();
        } catch(Exception e ){
            username = null;
        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    @Override
    public Date getExpirationDateFromToken(String token){
        Date expirationDate;
        try{
            final Claims claims = this.getClaimsFromToken(token);
            expirationDate = claims.getExpiration();
        } catch (Exception e){
            expirationDate = null;
        }
        return expirationDate;
    }

    private boolean isTokenExpired(String token){
        final Date expirationDate = this.getExpirationDateFromToken(token);
        return expirationDate.before(new Date(System.currentTimeMillis()));
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    @Override
    public String generateToken(User user){
        Map<String,Object> claims = new HashMap<>();
        claims.put("sub", user.getEmail());
        return Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.ES256, secret).compact();
    }
}
