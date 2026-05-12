package com.users_manage.demo.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
@Data
@Component

public class JwtUtil {


    private final static String secret = "clave_secreta";

    public static String getSecret() {
        return secret;
    }
    // Generar token JWT 
    public String generateToken(String documento) {      
        return Jwts.builder()
                .setSubject(documento)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(getSigningKey())
                .compact();

    }
    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public static String extraerDocumento(String token){
        return extraerClaims(token).getSubject();
    }

    private static Claims extraerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean esTokenValido(String token) {
        return !extraerClaims(token).getExpiration().before(new Date());
    }

}
